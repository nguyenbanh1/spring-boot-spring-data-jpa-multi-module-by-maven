package itsol.intership02.dao;

import itsol.intership02.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StaffDAO extends JpaRepository<Staff,Integer> {

    Optional<Staff> findByUsername(String username);

    Optional<Staff> findByStaffcode(String code);

}
