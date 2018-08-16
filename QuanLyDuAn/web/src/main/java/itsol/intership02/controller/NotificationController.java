package itsol.intership02.controller;

import itsol.intership02.dao.NotificationDAO;
import itsol.intership02.dao.StaffDAO;
import itsol.intership02.entities.Notification;
import itsol.intership02.entities.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationDAO notificationDAO;

    @Autowired
    private StaffDAO staffDAO;

    @RequestMapping(value = "new_notification", method = RequestMethod.POST, produces = {"application/json"})
    public void addNotification(@RequestBody Notification new_notification, @RequestHeader String code) {


        Staff staff_create = staffDAO.findByStaffcode(code).orElse(new Staff());
        Date date = new Date();

        new_notification.setDate_created(date);
        new_notification.setDate_update(date);
        new_notification.setUser_update(staff_create);
        new_notification.setUser_created(staff_create);
        new_notification.setStatus(true);

        notificationDAO.save(new_notification);

    }


    @RequestMapping(value = "test/notification/{code}", method = RequestMethod.GET, produces = {"application/json"})
    public Notification getStaffByCode(@PathVariable("code") String code) {
        return notificationDAO.findByCode(code).orElse(new Notification());
    }

    @RequestMapping(value = "test/notifications", method = RequestMethod.GET, produces = {"application/json"})
    public List<Notification> getAll() {
        return notificationDAO.findAll();
    }


}
