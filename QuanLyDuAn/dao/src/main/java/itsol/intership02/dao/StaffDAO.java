package itsol.intership02.dao;


import itsol.intership02.entities.Staff;
import itsol.intership02.generic.CustomRepository;
import itsol.intership02.generic.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffDAO extends JpaRepository<Staff,Integer>, CustomRepository {


    Optional<Staff> findByUsername(String username);

    Staff findByStaffcode(String code);

    boolean existsByUsername(String username);
    boolean existsByStaffcode(String staffCode);


    @Procedure(procedureName = "pgk_staff.delete_staff")
    void deleteStaff(@Param("p_staff_code") String p_staff_id, @Param("p_person_update")String p_person_update);




}
