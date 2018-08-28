package itsol.intership02.controller;
import itsol.intership02.StaffService;
import itsol.intership02.entities.Table_CV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CVController {
    @Autowired
    private CVDAO cvdao;

    @RequestMapping(value = "admin/area/post",method = RequestMethod.POST,produces = {"application/json"})
    public void postConfArea(@RequestBody Table_CV newTableCV)






}
