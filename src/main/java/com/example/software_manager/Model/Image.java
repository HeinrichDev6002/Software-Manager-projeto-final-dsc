package com.example.software_manager.Model;

import jakarta.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String imageId;
    @Column
    String url;

    public Image(String imageId, String url) {
        this.imageId = imageId;
        this.url = url;
    }
    public Image(){}

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
