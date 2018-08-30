package itsol.intership02;

import java.util.List;

public interface CycleService {

    List<Object> getOneByCode(String code);
    List<Object> getAllBy(String start_date,String end_date,int user_created_id);

}
