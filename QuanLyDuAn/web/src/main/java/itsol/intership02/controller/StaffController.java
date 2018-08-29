package itsol.intership02.controller;

import exception.NoInputDataException;
import itsol.intership02.StaffService;
import itsol.intership02.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import Utils.StringUtil;
import javax.persistence.StoredProcedureQuery;
import java.util.*;

@CrossOrigin
@RestController
public class StaffController {

    @Autowired
    private StaffService staffService;

    //them 1 staff vao DB
    @RequestMapping(value = "test/staff",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?> createStaff(@RequestBody Staff new_staff,@RequestHeader int id){
        HttpHeaders httpHeaders = new HttpHeaders();


        if(new_staff==null){
            httpHeaders.add("status","fail");
            httpHeaders.add("message","error");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
       // Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();
        new_staff.setDate_created(date);
        //new_staff.setDate_update(date);
        //new_staff.setUser_update(staff_create);
        //.out.print(staff_create.getId());
        //new_staff.setUser_created(staff_create.getId());
        new_staff.setUser_created(id);
        new_staff.setStatus(true);

        if(staffService.insert(new_staff))
            httpHeaders.add("status" , "success");

        else
            httpHeaders.add("status","fail");

        return ResponseEntity.accepted().headers(httpHeaders).build();

    }

//    update 1 staff
    @RequestMapping(value = "test/staff/edit/{code}",method = RequestMethod.PUT,produces = {"application/json"})
    public ResponseEntity<?> updateStaff(@RequestBody Staff updatedStaff, @PathVariable("code") String code){//,@RequestHeader String code){
        HttpHeaders httpHeaders = new HttpHeaders();
//        if (!updatedStaff.getStaffName().matches(StringUtil.NAME_REGEX))
//            throw new NoInputDataException("The name is invalid. Please input again!");
        Date date= new Date();
        boolean status;
        boolean gender;
        if (updatedStaff.isLook_status())
            status=true;
        else status=false;

        if (updatedStaff.isGender())
            gender=true;
        else gender=false;

        Staff staff= staffService.findByStaffCode(code);
        staff.setPhone_number(updatedStaff.getPhone_number());
        staff.setAddress(updatedStaff.getAddress());
        staff.setTemporary_address(updatedStaff.getTemporary_address());
        staff.setEmail(updatedStaff.getEmail());
        staff.setBanking_account(updatedStaff.getBanking_account());
        staff.setDegree(updatedStaff.getDegree());
        staff.setEnd_working_day(updatedStaff.getEnd_working_day());
        staff.setGender(gender);
        staff.setLook_status(status);



        staff.setDate_update(date);
        //staff.setUser_update(staffCode);

//        if(staffUpdate==null||updatedStaff==null)
//        {
//            httpHeaders.add("status","fail");
//            httpHeaders.add("message","error");
//            return ResponseEntity.noContent().headers(httpHeaders).build();
//        }
        staffService.saveOrUpdate(staff);
        httpHeaders.add("status" , "success");

        return ResponseEntity.accepted().headers(httpHeaders).build();
    }


    //delete 1 staff
   @RequestMapping(value = "test/staff/delete/{code}",method = RequestMethod.DELETE,produces = {"application/json"})
    public ResponseEntity<?>  deleteStaff(@PathVariable("code")String code,@RequestHeader String staffCode){
        HttpHeaders httpHeaders = new HttpHeaders();
        List params= Arrays.asList(code,staffCode);
        staffService.delete(params);
        httpHeaders.add("status" , "success");

        return ResponseEntity.accepted().headers(httpHeaders).build();

    }



    @RequestMapping(value = "/test/staff/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object>  getStaffByCode(@PathVariable("code")String code){
       List param= Arrays.asList(code);
       List<Object> list= staffService.getByStaffCode(param);
        return new ResponseEntity<>(list,HttpStatus.ACCEPTED);
    }


    @RequestMapping(value = "test/staff/all",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getAllStaff(@RequestParam(value = "code",required = false) String code,
    @RequestParam(value = "name",required = false) String name)
    {

        List param = Arrays.asList(code,name);
        List<Object> list = staffService.getAllStaff(param);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}
