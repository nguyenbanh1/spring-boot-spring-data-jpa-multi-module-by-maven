package itsol.intership02.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int id;


    @Column(name = "EMPLOYEE_CODE")
    private String code;


    @Column(name = "EMPLOYEE_USERNAME")
    private String username;

    @Column(name = "EMPLOYEE_PASSWORD")
    private String password;


    @Column(name = "DATE_CREATED")
    private Date day_created;

    @Column(name = "DATE_UPDATE")
    private Date date_update;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_CREATE")
    private Employee employee_create;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_UPDATE")
    private Employee employee_update;

    public Employee getEmployee_update() {
        return employee_update;
    }

    public void setEmployee_update(Employee employee_update) {
        this.employee_update = employee_update;
    }

    public Employee getEmployee_create() {
        return employee_create;
    }

    public void setEmployee_create(Employee employee_create) {
        this.employee_create = employee_create;
    }

    public Date getDay_created() {
        return day_created;
    }

    public void setDay_created(Date day_created) {
        this.day_created = day_created;
    }

    public Date getDate_update() {
        return date_update;
    }

    public void setDate_update(Date date_update) {
        this.date_update = date_update;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
