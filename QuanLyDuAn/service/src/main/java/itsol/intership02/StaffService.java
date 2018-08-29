package itsol.intership02;

import itsol.intership02.entities.Staff;

import java.util.List;

public interface StaffService {

    List<Object> getByStaffCode(List params);
    List<Object> getAllStaff(List params);
    void saveOrUpdate (Staff staff);
    void delete (List params);
    boolean insert (Staff staff);
    Staff findByStaffCode(String staffCode);
    boolean existsByStaffCode(String staffCode);
}
