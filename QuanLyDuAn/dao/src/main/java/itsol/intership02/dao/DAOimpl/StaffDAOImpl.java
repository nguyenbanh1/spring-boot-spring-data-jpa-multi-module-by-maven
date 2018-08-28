package itsol.intership02.dao.DAOimpl;

import itsol.intership02.generic.CustomRepository;
import itsol.intership02.generic.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaffDAOImpl implements CustomRepository {
    @Autowired
    private GenericRepository genericRepository;
    @Override
    public <T> List<T> getOne(List<T> params){
        return genericRepository.getEntityFromPackage("PGK_STAFF.get_one_staff",params);
    }
    @Override
    public <T> List<T> getList(List<T> params){
        return genericRepository.getEntityFromPackage("PGK_STAFF.get_all_staff",params);
    }
    @Override
    public <T> void executeSP(List<T> params){
        String spName = params.get(0).toString();
        params.remove(0);
        genericRepository.executeStoredProcedure(spName, params);
    }
}
