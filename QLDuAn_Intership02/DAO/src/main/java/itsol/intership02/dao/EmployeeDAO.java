package itsol.intership02.dao;


import itsol.intership02.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByCode(String code);
    boolean existsByCode(String code);

}
