package itsol.intership02.dao;


import itsol.intership02.Entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffDAO extends JpaRepository<Staff,Integer> {

}
