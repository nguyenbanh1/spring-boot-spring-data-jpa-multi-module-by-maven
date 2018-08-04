package itsol.intership02.service;

import itsol.intership02.Entities.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();
    List<Address> getAllByDescription(String description);
    void deleteAddress(int id);
    Address saveAddress(Address address);

}
