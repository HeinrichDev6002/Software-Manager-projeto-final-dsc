package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long userId;
    @Column(name = "name")
    String userName;
    @Column(name = "email")
    String userEmail;
    @OneToOne
    @JoinColumn(name = "photo_id")
    Image userImage;
    @Column(name = "password")
    String password;
    @OneToMany(mappedBy = "owner")
    List<Projects> projects;
    @ManyToMany(mappedBy = "users")
    List<Team> teams;

    public User(Long userId, String userName, String userEmail, Image userImage, String password, List<Projects> projects, List<Team> teams) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userImage = userImage;
        this.password = password;
        this.projects = projects;
        this.teams = teams;
    }
    public User(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Image getUserImage() {
        return userImage;
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Projects> getProjects() {
        return projects;
    }

    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
