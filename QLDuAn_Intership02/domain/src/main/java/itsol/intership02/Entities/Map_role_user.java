package itsol.intership02.Entities;

import javax.persistence.*;
import java.util.Date;

public class Map_role_user {
    @Column(name = "ROLE_USER)ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ROLE_ID")
    private Role role_id;

    @Column(name = "STAFF_ID")
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

}
