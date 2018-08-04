package itsol.intership02.service.Impl;

import itsol.intership02.Entities.Address;
import itsol.intership02.dao.AddressDAO;
import itsol.intership02.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "AddressService")
public class AddresssServiceImpl implements AddressService {

    @Autowired
    AddressDAO addressDAO;


    public List<Address> getAll(){
        return addressDAO.findAll();
    }


    public List<Address> getAllByDescription(String description){
        return addressDAO.findAllByDescription(description);
    }

    public void deleteAddress(int id){
        addressDAO.deleteById(id);
    }

    public Address saveAddress(Address address){
        System.out.println("save in DAO");
        Address add = addressDAO.save(address);
        if(add == null){

            return null;
        }
        System.out.println(add.getAddress_id() + " in Service");
        return add;
    }

}
