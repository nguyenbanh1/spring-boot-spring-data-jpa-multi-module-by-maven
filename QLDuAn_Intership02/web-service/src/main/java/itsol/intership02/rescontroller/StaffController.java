package itsol.intership02.rescontroller;


import itsol.intership02.Entities.Staff;
import itsol.intership02.dao.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    private StaffDAO staffDAO;



    //thêm dữ một list staff
    @RequestMapping(value = "staffs",method = RequestMethod.POST,produces = {"application/json"})
    public void postStaffs(@RequestBody List<Staff> staffs,@RequestHeader String code){


        Staff staffCreate = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();

        for(Staff e : staffs){


            e.setDate_created(date);
//            e.setDate_update(date);
//            e.setUser_update(staffCreate);
            e.setUser_created(staffCreate);
            e.setStatus(true);

            staffDAO.save(e);
        }

    }

    //them 1 staff vao DB
    @RequestMapping(value = "staff",method = RequestMethod.POST,produces = {"application/json"})
    public void postStaff(@RequestBody Staff new_staff,@RequestHeader String code){


        Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();

        new_staff.setDate_created(date);
//        new_staff.setDate_update(date);
//        new_staff.setUser_update(staff_create);
        new_staff.setUser_created(staff_create);
        new_staff.setStatus(true);

        staffDAO.save(new_staff);

    }



    @RequestMapping(value = "staff/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public Staff getStaffByCode(@PathVariable("code")String code){
        return staffDAO.findByStaffcode(code).orElse(new Staff());
    }


// delete mot staff chinguyen 14/08
    @RequestMapping(value = "staff/delete/{code}",method = RequestMethod.POST,produces = {"application/json"})
    public void deleteStaffByCode(@PathVariable("code")String code,@RequestHeader String updateStaffCode){
        Staff staffDelete = staffDAO.findByStaffcode(code).orElse(new Staff());
        Staff staffUpdate=staffDAO.findByStaffcode(updateStaffCode).orElse(new Staff());
        Date date = new Date();
        staffDelete.setStatus(false);
        staffDelete.setDate_update(date);
        staffDelete.setUser_update(staffUpdate);
        staffDAO.save(staffDelete);
//        return staffDAO.findByStaffcode(code).orElse(new Staff());
    }

    // update mot staff
    @RequestMapping(value = "staff/update/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public void updateStaffByCode(@RequestBody Staff updatedStaff,@RequestHeader String code){
        Staff staffUpdate = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();
        updatedStaff.setStatus(true);
        updatedStaff.setDate_update(date);
        updatedStaff.setUser_update(staffUpdate);
        staffDAO.save(updatedStaff);
//        return staffDAO.findByStaffcode(code).orElse(new Staff());
    }



    @RequestMapping(value = "staffs",method = RequestMethod.GET,produces = {"application/json"})
    public List<Staff> getAll(){
        return staffDAO.findAll();
    }


//    @RequestMapping(value = "staff",method = RequestMethod.PUT,produces = {"application/json"})
//    public void updateStaff(@RequestHeader String staffcode,@RequestBody Staff update_staff){
//
//        Staff staff_change = staffDAO.findByStaffcode(staffcode).orElse(new Staff());
//
//    }


}
