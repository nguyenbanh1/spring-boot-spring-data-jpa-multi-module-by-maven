package itsol.intership02.controller;

import itsol.intership02.StaffService;
import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class LoginController {

    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;


    @RequestMapping(value = "/register",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?> register(@RequestBody Staff staff){

        HttpHeaders httpHeaders = new HttpHeaders();


        if(staff == null || staff.getUsername() == null || staff.getPassword() == null){
            httpHeaders.add("status","fail");
            httpHeaders.add("message","object,username or password is null");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
        if(staffDAO.existsByUsername(staff.getUsername())){

            httpHeaders.add("status","fail");
            httpHeaders.add("message","username is exists");

            return ResponseEntity.badRequest().headers(httpHeaders).build();
        }



        Date date_current = new Date();
        staff.setDate_created(date_current);
        staff.setDate_update(date_current);
        String hashPassword = encoder.encode(staff.getPassword());
        staff.setPassword(hashPassword);

        staffDAO.save(staff);

        httpHeaders.add("status" ,"success");

        return ResponseEntity.accepted().headers(httpHeaders).build();

    }
    

}
