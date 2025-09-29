package com.example.software_manager.Model;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long imageId;
    @Column
    String url;

    public Image(Long imageId, String url) {
        this.imageId = imageId;
        this.url = url;
    }
    public Image(){}

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
