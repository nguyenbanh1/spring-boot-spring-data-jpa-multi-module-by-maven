package itsol.intership02.rescontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeDAO employeeDAO;

    @RequestMapping(value = "employee", method = RequestMethod.POST,produces = {"application/json"})
    public String postEmployee(@RequestHeader String code,@RequestBody Employee employee){

        Date date = new Date();
        if(employeeDAO.existsByCode(employee.getCode())){
            if(employee.getId() == 0){
                return "{ 'message' : 'object exist, not allow create,just change and let add field 'id' '}";
            }else{
                employee.setDate_update(date);

            }

        }else{

            Employee e = employeeDAO.findByCode(code).orElse(new Employee());

            if(e == null){
                return "{ 'message' : 'staff not exist'}";
            }
            employee.setDay_created(date);
            employee.setDate_update(date);
            employee.setEmployee_create(e);
            employee.setEmployee_update(e);


            employeeDAO.save(employee);
        }

        return "{ 'message' : 'success'}";

    }











}
