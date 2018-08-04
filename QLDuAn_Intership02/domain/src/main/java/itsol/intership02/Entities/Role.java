package itsol.intership02.Entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ROLE")
public class Role {


    @Id
    @Column(name = "Role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "Role_name",length = 50,nullable = false,unique = true)
    private String name;

    @Column(name = "Role_description")
    private String description;

    @Column(name = "Role_status")
    private boolean status = true;

    @Column(name = "Role_DAY_CREATE")
    private Date day_create;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDay_create() {
        return day_create;
    }

    public void setDay_create(Date day_create) {
        this.day_create = day_create;
    }
}
