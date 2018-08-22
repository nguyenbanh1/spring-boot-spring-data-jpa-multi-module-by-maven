package itsol.intership02.controller;



import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Staff;
import itsol.intership02.entities.StaffTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import java.util.*;

@CrossOrigin
@RestController
public class StaffController {

    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private EntityManager entityManager;

// chinguyen16/08

    //thêm dữ một list staff
    //    @RequestMapping(value = "staffs",method = RequestMethod.POST,produces = {"application/json"})
    //    public void postStaffs(@RequestBody List<Staff> staffs, @RequestHeader String code){
    //
    //
    //        Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
    //        Date date = new Date();
    //
    //        for(Staff e : staffs){
    //
    //
    //            e.setDate_created(date);
    //            e.setDate_update(date);
    //            e.setUser_update(staff_create);
    //            e.setUser_created(staff_create);
    //            e.setStatus(true);
    //
    //            staffDAO.save(e);
    //        }
    //    }

    //them 1 staff vao DB
    @RequestMapping(value = "test/staff",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?> postStaff(@RequestBody Staff new_staff,@RequestHeader String code){
        HttpHeaders httpHeaders = new HttpHeaders();
        if(new_staff==null){
            httpHeaders.add("status","fail");
            httpHeaders.add("message","error");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
         Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();
        new_staff.setDate_created(date);
        new_staff.setDate_update(date);
        //new_staff.setUser_update(staff_create);
        new_staff.setUser_created(staff_create);
        new_staff.setStatus(true);

        staffDAO.save(new_staff);
        httpHeaders.add("status" , "success");

        return ResponseEntity.accepted().headers(httpHeaders).build();

    }

    //update 1 staff
    @RequestMapping(value = "test/staff/edit={code}",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?> updateStaff(@RequestBody Staff updateInfo, @PathVariable("code") String code){//,@RequestHeader String code){
        HttpHeaders httpHeaders = new HttpHeaders();
        Staff staffUpdate = staffDAO.findByStaffcode(code).orElse(new Staff());
        if(staffUpdate==null||updateInfo==null)
        {
            httpHeaders.add("status","fail");
            httpHeaders.add("message","error");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
        Date date = new Date();

        staffUpdate.setDate_update(date);
        //updateStaff.setUser_update(stafUpdate);

        staffDAO.save(staffUpdate);

        httpHeaders.add("status" , "success");

        return ResponseEntity.accepted().headers(httpHeaders).build();
    }


    //delete 1 staff
    @RequestMapping(value = "test/staff/delete={code}",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?>  deleteStaff(@PathVariable("code")String code,@RequestHeader String code2){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (code2==null){
            httpHeaders.add("status","fail");
            httpHeaders.add("message","error");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
        staffDAO.deleteStaff(code,code2);
        httpHeaders.add("status" , "success");

        return ResponseEntity.accepted().headers(httpHeaders).build();

    }



    @RequestMapping(value = "/test/staff/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public Staff getStaffByCode(@PathVariable("code")String code){
        System.out.print("in get staff");
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getbycode");
        if(query == null){
            System.out.print("oke null");
        }
        query.setParameter("p_staff_code",code);
        query.execute();
        return (Staff) query.getSingleResult();
    }
    //get all xong
    @RequestMapping(value = "test/staffs",method = RequestMethod.GET,produces = {"application/json"})
    public List<Staff> getAll(){
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("getall");
        query.execute();
        List<Staff> staffs=query.getResultList();
       return staffs;
    }


    @RequestMapping(value = "/test/getAll",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getAllStaff(){

        StaffTest staffTest = new StaffTest();
        staffTest.setId(1);
        staffTest.setName("Phuong");
        staffTest.setBirthday("4/2/1997");
        staffTest.setDegree("tot tai nong lam");
        staffTest.setGender(0);
        staffTest.setEmail("phuongnhaidau@gmail.com");
        staffTest.setPhone("12321312312");

        staffTest.setLookStatus(1);


        StaffTest staffTest1 = new StaffTest();
        staffTest1.setId(2);
        staffTest1.setName("Lài điên");
        staffTest1.setBirthday("4/2/1997");
        staffTest1.setDegree("tot tai nong lam");
        staffTest1.setGender(0);
        staffTest1.setEmail("laidien@gmail.com");
        staffTest1.setPhone("12321312312");
        staffTest1.setLookStatus(1);



        List<StaffTest> staffTests = new ArrayList<>();
        staffTests.add(staffTest);
        staffTests.add(staffTest1);


        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("authentication", "lai dien");

        return new ResponseEntity(staffTests,responseHeaders,HttpStatus.OK);
    }


}
