package itsol.intership02.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STAFF")
public class Staff {

    @Column(name = "STAFF_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "CONF_AREA_ID")
    private Conf_Area conf_area_id;


    @Column(name = "MEDIA_URL")
    private int media_URL;

    @Column(name = "STAFF_CODE")
    private String staffcode;


    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "GENDER")
    private boolean gender;

    @Column(name = "DATE_OF_BIRTH")
    private Date date_of_birth;


    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "TEMPORARY_ADDRESS")
    private String temporary_address;


    @Column(name = "IDENTIFICATION_CARD")
    private String indetification_card;

    @Column(name = "DATE_OF_ISSUE")
    private String date_of_issue;

    @Column(name = "PLACE_OF_ISSUE")
    private String place_of_issue;

    @Column(name = "PHONE_NUMBER")
    private String phone_number;

    @Column(name = "EMAIL")
    private String email;


    @Column(name = "BANKING_ACCOUNT")
    private String banking_account;

    @Column(name = "TAX_CODE")
    private String tax_code;


    @Column(name = "DEGREE")
    private String degree;

    @ManyToOne
    @JoinColumn(name = "USER_CREATED")
    private Staff user_created;

    @ManyToOne
    @JoinColumn(name = "USER_UPDATE")
    private Staff user_update;

    @Column(name = "DATE_CREATED")
    private Date date_created;

    @Column(name = "DATE_UPDATE")
    private Date date_update;

    @Column(name = "NUM_LOGIN_FAIL")
    private int num_login_fail;

    @Column(name = "LOOK_STATUS")
    private boolean look_status;

    @Column(name = "START_PROBATIONARY_PERIO")
    private Date start_probationary_perio;

    @Column(name = "START_WORKING_DAY")
    private Date start_working_day;

    @Column(name = "END_WORKING_DAY")
    private Date end_working_day;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "POSITION",length = 20)
    private String position;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Conf_Area getConf_area_id() {
        return conf_area_id;
    }

    public void setConf_area_id(Conf_Area conf_area_id) {
        this.conf_area_id = conf_area_id;
    }

    public int getMedia_URL() {
        return media_URL;
    }

    public void setMedia_URL(int media_URL) {
        this.media_URL = media_URL;
    }

    public String getStaffcode() {
        return staffcode;
    }

    public void setStaffcode(String staffcode) {
        this.staffcode = staffcode;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTemporary_address() {
        return temporary_address;
    }

    public void setTemporary_address(String temporary_address) {
        this.temporary_address = temporary_address;
    }

    public String getIndetification_card() {
        return indetification_card;
    }

    public void setIndetification_card(String indetification_card) {
        this.indetification_card = indetification_card;
    }

    public String getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getPlace_of_issue() {
        return place_of_issue;
    }

    public void setPlace_of_issue(String place_of_issue) {
        this.place_of_issue = place_of_issue;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBanking_account() {
        return banking_account;
    }

    public void setBanking_account(String banking_account) {
        this.banking_account = banking_account;
    }

    public String getTax_code() {
        return tax_code;
    }

    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Staff getUser_created() {
        return user_created;
    }

    public void setUser_created(Staff user_created) {
        this.user_created = user_created;
    }

    public Staff getUser_update() {
        return user_update;
    }

    public void setUser_update(Staff user_update) {
        this.user_update = user_update;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

    public int getNum_login_fail() {
        return num_login_fail;
    }

    public void setNum_login_fail(int num_login_fail) {
        this.num_login_fail = num_login_fail;
    }

    public boolean isLook_status() {
        return look_status;
    }

    public void setLook_status(boolean look_status) {
        this.look_status = look_status;
    }

    public Date getStart_probationary_perio() {
        return start_probationary_perio;
    }

    public void setStart_probationary_perio(Date start_probationary_perio) {
        this.start_probationary_perio = start_probationary_perio;
    }

    public Date getStart_working_day() {
        return start_working_day;
    }

    public void setStart_working_day(Date start_working_day) {
        this.start_working_day = start_working_day;
    }

    public Date getEnd_working_day() {
        return end_working_day;
    }

    public void setEnd_working_day(Date end_working_day) {
        this.end_working_day = end_working_day;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
