package itsol.intership02.Impl;

import exception.DataNotFoundException;
import itsol.intership02.StaffService;
import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Staff;
import itsol.intership02.generic.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDAO staffDAO;

    @Autowired
    private GenericRepository genericRepository;



    @Override
    public List<Object> getAllStaff(List params) {
        return staffDAO.getList(params);
    }

    @Override
    public void saveOrUpdate(Staff staff) {
        staffDAO.save(staff);
    }


    @Override
    public List<Object> getByStaffCode(List params) {
        String staffCode = params.get(0).toString();
        findByStaffCode(staffCode);
        return staffDAO.getOne(params);
    }

    @Override
    public Staff findByStaffCode(String staffCode) {
        Staff result=staffDAO.findByStaffcode(staffCode);
        if (result==null)
            throw new DataNotFoundException("Staff could not be found with staffCode = " + staffCode);
        return staffDAO.findByStaffcode(staffCode);
    }



    @Override
    public void delete(List params) {
        //id update truoc, id nguoi update sau
        String staffcode = params.get(0).toString();
        findByStaffCode(staffcode);

        List list = new ArrayList();
        list.add (0,"PGK_STAFF.delete_staff ");
        list.addAll(params);
        staffDAO.executeSP(list);
    }

    @Override
    public void insert(Staff staff) {

    }
}
