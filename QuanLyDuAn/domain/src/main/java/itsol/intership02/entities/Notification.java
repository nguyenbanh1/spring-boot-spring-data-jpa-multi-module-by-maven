package itsol.intership02.entities;

import javax.persistence.*;

@Entity
@Table(name = "COMPANY_NOTIFICATION")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COMPANY_NOTIFICATION_ID")
    private int id;

    @Column(name = "COMPANY_NOTIFICATION_CODE")
    private String code;

    @Column(name = "COMPANY_NOTIFICATION_NAME")
    private String name;

    @Column(name = "MEDIA_ID")
    private int mediaId;

    @Column(name = "STAFF_ID")
    private int staffId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "COMPANY_NOTIFICATION_CONTENT")
    private String content;

    @Column(name = "URL_TEMPLATE")
    private String urlTemplate;

    @Column(name = "APPLY_FOR_ID")
    private int appplyForId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMediaId() {
        return mediaId;
    }

    public void setMediaId(int mediaId) {
        this.mediaId = mediaId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate;
    }

    public int getAppplyForId() {
        return appplyForId;
    }

    public void setAppplyForId(int appplyForId) {
        this.appplyForId = appplyForId;
    }
}