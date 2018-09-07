package itsol.intership02.dao;

import itsol.intership02.entities.Contract;
import itsol.intership02.generic.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDAO extends JpaRepository<Contract,Integer>, CustomRepository {

    boolean existsContractByCode(String contractCode);


}
