package itsol.intership02.controller;



import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffDAO staffDAO;

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
        // Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();
        new_staff.setDate_created(date);
        new_staff.setDate_update(date);
        //new_staff.setUser_update(staff_create);
        //.setUser_created(staff_create);
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



    @RequestMapping(value = "test/staff/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public Staff getStaffByCode(@PathVariable("code")String code){
        return staffDAO.findByStaffcode(code).orElse(new Staff());
    }

    @RequestMapping(value = "test/staffs",method = RequestMethod.GET,produces = {"application/json"})
    public List<Staff> getAll(){
        return staffDAO.findAll();
    }


}
