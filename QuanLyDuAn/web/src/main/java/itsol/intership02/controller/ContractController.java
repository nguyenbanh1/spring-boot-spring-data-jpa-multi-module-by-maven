package itsol.intership02.controller;


import itsol.intership02.ContractService;
import itsol.intership02.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class ContractController {

    @Autowired
    ContractService contractService;

    @RequestMapping(value = "test/contract/all",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Object> getAllContract(@RequestParam(value = "code",required = false) String code,
                                              @RequestParam(value = "name",required = false) String name)
    {

        List param = Arrays.asList(code,name);
        List<Object> list = contractService.getAllContract(param);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


    @RequestMapping(value = "test/contract",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<?> insertContract(@RequestBody Contract new_contract, @RequestHeader int id){
        HttpHeaders httpHeaders = new HttpHeaders();
        if(new_contract==null){
            httpHeaders.add("status","fail");
            httpHeaders.add("message","error");
            return ResponseEntity.noContent().headers(httpHeaders).build();
        }
        boolean x = true;
        Date date = new Date();
        new_contract.setDate_created(date);
        new_contract.setUser_created(id);
        new_contract.setStatus(x);
        if(contractService.insert(new_contract))
            httpHeaders.add("status" , "success");
        else
            httpHeaders.add("status","fail");
        return ResponseEntity.accepted().headers(httpHeaders).build();
    }
}
