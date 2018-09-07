package itsol.intership02;

import java.util.List;
import itsol.intership02.entities.Contract;


public interface ContractService {

    List<Object> getAllContract(List params);
    boolean insert (Contract contract);
    boolean existsContractByCode(String contractCode);
}
