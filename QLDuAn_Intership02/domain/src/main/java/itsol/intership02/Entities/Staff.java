package itsol.intership02.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "STAFF")
public class Staff {


    @Id
    @Column(name = "STAFF_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "STAFF_SALARY")
    private long salary;


    @Column(name = "STAFF_STATUS")
    private boolean status = true;

    @Column(name = "STAFF_USERNAME")
    private String username;


    @Column(name = "STAFF_PASSWORD")
    private String password;



    @Column(name = "STAFF_DAY_CREATE")
    private Date day_create;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDay_create() {
        return day_create;
    }

    public void setDay_create(Date day_create) {
        this.day_create = day_create;
    }
}
