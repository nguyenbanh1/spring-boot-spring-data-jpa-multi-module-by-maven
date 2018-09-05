//package itsol.intership02.Impl;
//
//import itsol.intership02.CycleService;
//import itsol.intership02.dao.CycleDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class CycleServiceImpl implements CycleService {
//
//    @Autowired
//    private CycleDAO cycleDAO;
//
//    @Override
//    public List<Object> getOneByCode(String code) {
//        List param = Arrays.asList(code);
//        return cycleDAO.getOne(param);
//    }
//
//    @Override
//    public List<Object> getAllBy(String start_date, String end_date, int user_created_id) {
//        List params = Arrays.asList(start_date,end_date,user_created_id);
//        return cycleDAO.getList(params);
//    }
//}
