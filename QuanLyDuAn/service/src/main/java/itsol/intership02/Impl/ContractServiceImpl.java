package itsol.intership02.Impl;

import Utils.StringUtil;
import exception.NoInputDataException;
import itsol.intership02.ContractService;
import itsol.intership02.dao.ContractDAO;
import itsol.intership02.entities.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractDAO contractDAO;


    @Override
    public List<Object> getAllContract(List params) {
        return contractDAO.getList(params);
    }



    @Override
    public boolean existsContractByCode(String contractCode) {
        return contractDAO.existsContractByCode(contractCode);
    }

    @Override
    public boolean insert(Contract contract) {
        String contractCode  = contract.getCode();
        if(existsContractByCode(contractCode))
        {
            throw new DuplicateKeyException("Đui hã hông tháy trùng code rồi ");
        }
        if(StringUtil.isNullOrEmpty(contract.getName())) {
            throw new NoInputDataException("chống rỗng");
        }
        contractDAO.save(contract);
        return true;
    }

}
