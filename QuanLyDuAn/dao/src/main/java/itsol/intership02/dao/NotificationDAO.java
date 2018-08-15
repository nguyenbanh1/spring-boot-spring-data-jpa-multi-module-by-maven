package itsol.intership02.dao;

import itsol.intership02.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NotificationDAO extends JpaRepository<Notification,Integer> {
}
