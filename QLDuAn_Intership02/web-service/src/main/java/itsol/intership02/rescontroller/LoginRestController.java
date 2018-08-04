package itsol.intership02.rescontroller;

import itsol.intership02.Entities.Address;
import itsol.intership02.Entities.Staff;
import itsol.intership02.service.AddressService;

import itsol.intership02.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import java.net.URI;
import java.util.List;

@RestController
public class LoginRestController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private StaffService userService;



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Address> home(){
        return addressService.getAll();
    }

    @RequestMapping(value = "/address/{des}",method = RequestMethod.GET)
    public List<Address> getAllByDescription(@PathVariable("des") String des){
        return addressService.getAllByDescription(des);
    }

    @RequestMapping(value = "/delete/address/{id}",method = RequestMethod.DELETE)
    public String deleteAddressById(@PathVariable("id")int id){

        addressService.deleteAddress(id);
        return "deleted";
    }

    @RequestMapping(value = "/post/address",method = RequestMethod.POST)
    public ResponseEntity<Object> postAddress(@RequestBody Address p_address){

        addressService.saveAddress(p_address);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(p_address.getAddress_id()).toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value = "/post/user",method = RequestMethod.POST)
    public ResponseEntity<Object> saveUser(@RequestBody Staff p_staff){

        userService.save(p_staff);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(p_staff.getId()).toUri();

        return ResponseEntity.created(location).build();


    }


}
