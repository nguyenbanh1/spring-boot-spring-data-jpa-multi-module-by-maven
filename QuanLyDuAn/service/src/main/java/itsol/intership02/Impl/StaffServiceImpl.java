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
    private GenericRepository genericRepository;

    @Autowired
    private StaffDAO staffdao;

    @Override
    public List<Object> getOne(List params) {
        return genericRepository.getEntityFromPackage("PGK_STAFF.get_one_staff",params);
    }

    @Override
    public List<Object> getAll(List params) {
        return genericRepository.getEntityFromPackage("PGK_STAFF.get_all_staff",params);
    }

    @Override
    public void update(Staff staff) {
    }

    @Override
    public Staff findbyStaffcode (String staffcode){
        Staff staff = staffdao.findByStaffcode(staffcode);
        if(staff == null)
        {
            throw new DataNotFoundException("Staff code not be found with staffcode :"+ staffcode);
        }
        return staffdao.findByStaffcode(staffcode);
    }
    @Override
    public void delete(List params) {
        String staffcode = params.get(0).toString();
        findbyStaffcode(staffcode);

        List list = new ArrayList();
        list.add (0,"PGK_STAFF.DELETE_STAFF");
        list.addAll(params);
        staffdao.executeSP(list);


    }

    @Override
    public void insert(Staff staff) {

    }
}
