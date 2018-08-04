package itsol.intership02.service.Impl;

import itsol.intership02.Entities.Staff;
import itsol.intership02.dao.StaffDAO;
import itsol.intership02.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    StaffDAO userDAO;

    @Override
    public void save(Staff user) {
        userDAO.save(user);
    }
}
