package itsol.intership02.rescontroller;

import itsol.intership02.Entities.Conf_Area;
import itsol.intership02.dao.ConfAreaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import java.util.List;

@RestController
public class ConfAreaController {
    @Autowired
    @Qualifier("confAreaDAO")
    private ConfAreaDAO confAreaDAO;



    //them ConfArea chinguyen 15/8
    @RequestMapping(value = "area/post",method = RequestMethod.POST,produces = {"application/json"})
    public void postConfArea(@RequestBody Conf_Area newConfArea){//,@RequestHeader String code){

        //Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();

        newConfArea.setDate_created(date);
        //   newConfArea.setUser_created(staff_create);
        newConfArea.setStatus(true);

        confAreaDAO.save(newConfArea);
    }

    //getALL
    @RequestMapping(value = "area",method = RequestMethod.GET,produces = {"application/json"})
    public List<Conf_Area> getAll(){
        return confAreaDAO.findAll();
    }

//    @RequestMapping(value = "area/{code}",method = RequestMethod.GET,produces = {"application/json"})
//    public Conf_Area getByCode(@PathVariable("code") String code){
//        return confAreaDAO.findByConf_area_code(code);
//    }


}
