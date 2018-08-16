package itsol.intership02.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "MAP_ROLE_STAFF")
public class Map_role_user {
    @Column(name = "ROLE_USER_ID")
    @Id
    @SequenceGenerator(name = "Role_UserGenerator",sequenceName = "Role_User_sequence")
    @GeneratedValue(generator = "Role_UserGenerator")
    private int id;

    @JoinColumn(name = "ROLE_ID")
    @ManyToOne
    private Role role_id;

    @JoinColumn(name = "STAFF_ID")
    @ManyToOne
    private Staff staff_id;


    @ManyToOne
    @JoinColumn(name = "USER_CREATED")
    private Staff user_created;

    @ManyToOne
    @JoinColumn(name = "USER_UPDATE")
    private Staff user_update;


    @Column(name = "DATE_CREATED")
    private Date date_created;

    @Column(name = "DATE_UPDATE")
    private Date date_update;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    public Staff getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(Staff staff_id) {
        this.staff_id = staff_id;
    }

    public Staff getUser_created() {
        return user_created;
    }

    public void setUser_created(Staff user_created) {
        this.user_created = user_created;
    }

    public Staff getUser_update() {
        return user_update;
    }

    public void setUser_update(Staff user_update) {
        this.user_update = user_update;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }
}
