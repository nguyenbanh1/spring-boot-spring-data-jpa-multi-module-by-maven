package itsol.intership02.dao;

import itsol.intership02.entities.TimesheetDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSheetDetail extends JpaRepository<TimesheetDetail,Integer> {
}
