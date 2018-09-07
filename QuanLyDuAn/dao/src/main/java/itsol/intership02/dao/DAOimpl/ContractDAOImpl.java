package itsol.intership02.dao.DAOimpl;

import itsol.intership02.generic.CustomRepository;
import itsol.intership02.generic.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractDAOImpl implements CustomRepository {

    @Autowired
    private GenericRepository genericRepository;
    @Override
    public <T> List<T> getOne(List<T> params){
        return genericRepository.getEntityFromPackage("PGK_CONTRACT.get_one_contract",params);
    }
    @Override
    public <T> List<T> getList(List<T> params){
        return genericRepository.getEntityFromPackage("PGK_CONTRACT.get_all_contract",params);
    }
    @Override
    public <T> void executeSP(List<T> params) {
        String spName = params.get(0).toString();
        params.remove(0);
        genericRepository.executeStoredProcedure(spName, params);
    }
}
