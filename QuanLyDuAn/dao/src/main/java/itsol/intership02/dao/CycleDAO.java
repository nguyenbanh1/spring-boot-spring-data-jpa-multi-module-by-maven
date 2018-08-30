package itsol.intership02.dao;

import itsol.intership02.entities.Cycle;
import itsol.intership02.generic.CustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CycleDAO extends JpaRepository<Cycle,Integer>,CustomRepository {

}
