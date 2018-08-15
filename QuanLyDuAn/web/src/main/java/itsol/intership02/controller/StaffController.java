package itsol.intership02.controller;



import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Staff;
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
    public void postStaffs(@RequestBody List<Staff> staffs, @RequestHeader String code){


        Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();

        for(Staff e : staffs){


            e.setDate_created(date);
            e.setDate_update(date);
            e.setUser_update(staff_create);
            e.setUser_created(staff_create);
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
        new_staff.setDate_update(date);
        new_staff.setUser_update(staff_create);
        new_staff.setUser_created(staff_create);
        new_staff.setStatus(true);

        staffDAO.save(new_staff);

    }



    @RequestMapping(value = "staff/{code}",method = RequestMethod.GET,produces = {"application/json"})
    public Staff getStaffByCode(@PathVariable("code")String code){
        return staffDAO.findByStaffcode(code).orElse(new Staff());
    }

    @RequestMapping(value = "staffs",method = RequestMethod.GET,produces = {"application/json"})
    public List<Staff> getAll(){
        return staffDAO.findAll();
    }


}
