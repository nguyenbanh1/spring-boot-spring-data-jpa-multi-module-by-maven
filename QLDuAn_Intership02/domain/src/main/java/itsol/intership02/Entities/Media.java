package itsol.intership02.Entities;

import javax.persistence.*;

@Entity
@Table(name = "MEDIA")
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEDIA_ID")
    private int id;

    @Column(name = "MEDIA_CODE")
    private String code;

    @Column(name = "MEDIA_NAME")
    private String name;

    @Column(name = "MEDIA_DESCRIPTION")
    private String description;

    @Column(name = "MEDIA_URL")
    private String mediaURL;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMediaURL() {
        return mediaURL;
    }

    public void setMediaURL(String mediaURL) {
        this.mediaURL = mediaURL;
    }
}
