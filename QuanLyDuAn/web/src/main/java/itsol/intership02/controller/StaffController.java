package itsol.intership02.controller;

import itsol.intership02.StaffService;
import itsol.intership02.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.StoredProcedureQuery;
import java.util.*;

@CrossOrigin
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    //them 1 staff vao DB
//    @RequestMapping(value = "test/staff",method = RequestMethod.POST,produces = {"application/json"})
//    public ResponseEntity<?> postStaff(@RequestBody Staff new_staff,@RequestHeader int id){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        if(new_staff==null){
//            httpHeaders.add("status","fail");
//            httpHeaders.add("message","error");
//            return ResponseEntity.noContent().headers(httpHeaders).build();
//        }
//       // Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
//        Date date = new Date();
//        new_staff.setDate_created(date);
//        //new_staff.setDate_update(date);
//        //new_staff.setUser_update(staff_create);
//        //.out.print(staff_create.getId());
//        //new_staff.setUser_created(staff_create.getId());
//        new_staff.setUser_created(id);
//        new_staff.setStatus(true);
//
//        staffDAO.save(new_staff);
//        httpHeaders.add("status" , "success");
//
//        return ResponseEntity.accepted().headers(httpHeaders).build();
//
//    }

    //update 1 staff
//    @RequestMapping(value = "test/staff/edit/{code}",method = RequestMethod.POST,produces = {"application/json"})
//    public ResponseEntity<?> updateStaff(@RequestBody Staff updatedStaff, @PathVariable("code") String code){//,@RequestHeader String code){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        //Staff staffUpdate = staffDAO.findByStaffcode(code).orElse(new Staff());
//        if(staffUpdate==null||updatedStaff==null)
//        {
//            httpHeaders.add("status","fail");
//            httpHeaders.add("message","error");
//            return ResponseEntity.noContent().headers(httpHeaders).build();
//        }
//        Date date = new Date();
//        updatedStaff.setDate_update(date);
//        updatedStaff.setUser_update(staffUpdate.getId());
//        //updateStaff.setUser_update(staffUpdate);
//
//        //staffDAO.save(updatedStaff);
//
//        httpHeaders.add("status" , "success");
//
//        return ResponseEntity.accepted().headers(httpHeaders).build();
//    }


    //delete 1 staff
   @RequestMapping(value = "test/staff/delete/{code}",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?>  deleteStaff(@PathVariable("code")String code,@RequestHeader String code2){
        HttpHeaders httpHeaders = new HttpHeaders();
        if (code2==null){
            httpHeaders.add("status","fail");
            httpHeaders.add("message","error");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
        //staffDAO.deleteStaff(code,code2);
        httpHeaders.add("status" , "success");

        return ResponseEntity.accepted().headers(httpHeaders).build();

    }



    @RequestMapping(value = "/test/staff/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public Staff getStaffByCode(@PathVariable("code")String code){
        return null;
    }


    @RequestMapping(value = "/staff/all",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getAllStaff(
            @RequestParam(value = "code",required = false) String code,
            @RequestParam(value = "name",required = false) String name)
    {

        List param = Arrays.asList(code,name);
        List<Object> list = staffService.getAll(param);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}
