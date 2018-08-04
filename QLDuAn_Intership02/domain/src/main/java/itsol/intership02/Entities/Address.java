package itsol.intership02.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int address_id;

    @Column(name = "ADDRESS_NAME")
    private String address_name;

    @Column(name = "STATUS")
    private boolean status = true;

    @Column(name = "ADDRESS_DAY_CREATE")
    private Date day_create = new Date();

    @Column(name = "DESCRIPTION")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}