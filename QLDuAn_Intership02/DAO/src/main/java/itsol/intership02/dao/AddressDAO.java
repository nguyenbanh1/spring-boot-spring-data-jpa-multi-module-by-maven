package itsol.intership02.dao;


import itsol.intership02.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface AddressDAO extends JpaRepository<Address,Integer> {

    List<Address> findAllByDescription(String description);
}