create PACKAGE BODY pgk_staff AS

    PROCEDURE delete_staff (
        p_staff_code STRING,
        p_person_update String
    )
        AS
    BEGIN
        UPDATE STAFF s
        SET
            s.status =0,
            s.user_update = p_person_update,
            s.date_update = current_date
        WHERE
            s. = p_staff_code;
-- UPDATE STATUS MEDIA

--        UPDATE media m
--            SET
--                m.status =-1,
--                m.user_update = p_person_update,
--                m.date_update = current_date
--        WHERE
--            m.staff_id IN (
--                SELECT
--                    staff_id
--                FROM
--                    media
--                WHERE
--                    staff_id = p_staff_id
--            );
          
--    UPDATE STATUS NOTIFICATION

--        UPDATE company_notification b
--            SET
--                b.status =-1,
--                b.user_update = p_person_update,
--                b.date_update = current_date
--        WHERE
--            b.staff_id IN (
--                SELECT
--                    STAFF_ID
--                FROM
--                    company_notification
--                WHERE
--                    company_notification.staff_id = staff.STAFF_ID 
--            );
--

    END delete_staff;

    PROCEDURE get_one_staff (
        o_res OUT SYS_REFCURSOR,
        p_staff_code IN STRING
    )
        AS
    BEGIN
        OPEN o_res FOR SELECT
            s.staff_code                        staffcode,
            s.staff_name                        staffname,
            (
                CASE s.GENDER
                    WHEN 0   THEN 'Nam'
                    WHEN 1   THEN 'Nữ'
                    ELSE ''
                END
            )                                   gender,
            s.DATE_OF_BIRTH                     dob,
            s.ADDRESS                           address,
            s.TEMPORARY_ADDRESS                 tempAddress,
            s.IDENTIFICATION_CARD               idCard,
            s.DATE_OF_ISSUE                     doi,
            s.PLACE_OF_ISSUE                    poi,
            s.PHONE_NUMBER                      phoneNum,
            s.EMAIL                             email,
            s.BANKING_ACCOUNT                   bankAccount,
            s.TAX_CODE                          taxCode,
            s.STAFF_DEGREE                      staffDegree,
            s.NUM_LOGIN_FAIL                    numLoginFail,         
            (
                CASE s.look_status
                    WHEN 0   THEN 'Khác'
                    WHEN 1   THEN 'Đang làm việc'
                    ELSE ''
                END
            )                                   lookStatus,
            s.START_PROBATIONARY_PERIO          startProdationary,
            s.START_WORKING_DAY                 startWorkDay,
            s.END_WORKING_DAY                   endWorkDay,
            s.POSITION                          position
            
                       FROM
            STAFF s
    --join left MEDIA me on me.STAFF_ID=s.staff_id
                       WHERE
            (
                p_staff_code IS NULL
                OR s.STAFF_CODE = p_staff_code
            )AND 
            s.STATUS=1;

    END get_one_staff;
    
    
    PROCEDURE get_all_staff(
        o_res OUT SYS_REFCURSOR
    )AS
    BEGIN
    OPEN o_res FOR SELECT
            s.staff_code                        staffcode,
            s.staff_name                        staffname,
            (
                CASE s.GENDER
                    WHEN 0   THEN 'Nam'
                    WHEN 1   THEN 'Nữ'
                    ELSE ''
                END
            )                                   gender,
            s.DATE_OF_BIRTH                     dob,
            s.ADDRESS                           address,
            s.TEMPORARY_ADDRESS                 tempAddress,
            s.IDENTIFICATION_CARD               idCard,
            s.DATE_OF_ISSUE                     doi,
            s.PLACE_OF_ISSUE                    poi,
            s.PHONE_NUMBER                      phoneNum,
            s.EMAIL                             email,
            s.BANKING_ACCOUNT                   bankAccount,
            s.TAX_CODE                          taxCode,
            s.STAFF_DEGREE                      staffDegree,
            s.NUM_LOGIN_FAIL                    numLoginFail,         
            (
                CASE s.look_status
                    WHEN 0   THEN 'Khác'
                    WHEN 1   THEN 'Đang làm việc'
                    ELSE ''
                END
            )                                   lookStatus,
            s.START_PROBATIONARY_PERIO          startProdationary,
            s.START_WORKING_DAY                 startWorkDay,
            s.END_WORKING_DAY                   endWorkDay,
            s.POSITION                          position
            
                       FROM
            staff s;
    
    END get_all_staff;
    
    
     procedure getCompanyOnsite(p_code in String,o_res out sys_refcursor) as
     begin
        
        open o_res for 
            select c.COMPANY_CODE,c.COMPANY_NAME,c.EMAIL,c.FAX,c.LATITUDE,c.LONGITUDE,c.PHONE_NUMBER,c.TAX_CODE,c.TITLE,c.WEBSITE,c.ADDRESS
                from COMPANY c where COMPANY_ID in ( 
                select cp.COMPANY_ID from COMPANY_PROJECT cp join STAFF s on s.STAFF_ID = cp.STAFF_ID );
        
     end;
     
    

    
    
    
    
    

--    PROCEDURE get_a (
--        p_id                 STRING,
--        p_code               STRING,
--        p_name               STRING,
--        p_dob                DATE,
--        p_address            STRING,
--        p_sex                NUMBER,
--        p_startworkingdate   DATE,
--        --LOOK STATUS
--        p_position           STRING,
--        cur_result           OUT SYS_REFCURSOR
--    )
--        AS
--    BEGIN
--        OPEN cur_result FOR SELECT
--            s.staff_name,
--            s.gender,
--            s.date_of_birth,
--            s.phone_number,
--            s.email,
--            s.degree,
--            s.look_status,
--            s.address,
--            s.temporary_address,
--            s.identification_card,
--            s.date_of_issue,
--            s.place_of_issue,
--            s.banking_account,
--            s.tax_code,
--            s.position,
--            s.look_status,
--            s.start_probationary_perio,
--            s.end_probationary_perio,
--            s.start_working_day,
--            s.end_working_day
--                            FROM
--            staff s
--                            WHERE
--            (
--                p_id IS NULL
--                OR    s.staff_id = p_id
--            )
--            AND 
--            
--            
--            --HUY DAU VA IN HOA LIKE
--             (
--                p_code IS NULL
--                OR    s.staff_code = p_code
--            )
--            AND   (
--                p_name IS NULL
--                OR    s.staff_name = p_name
--            )
--            AND   (
--                p_dob IS NULL
--                OR    s.date_of_birth = p_dob
--            )
--            AND   (
--                p_address IS NULL
--                OR    s.address = p_address
--            )
--            AND   (
--                p_sex IS NULL
--                OR    s.gender = p_sex
--            )
--            AND   (
--                p_startworkingdate IS NULL
--                OR    s.start_working_day = p_startworkingdate
--            )
--            AND   (
--                p_position IS NULL
--                OR    s.position = p_position
--            );
--
--    END get_a;

END pgk_staff;
/

