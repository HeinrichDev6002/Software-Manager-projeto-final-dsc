package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long projectId;
    @Column
    String projectName;
    @Column
    LocalDate deadline;
    @Column
    String desc;//description
    @Column
    String visibility; //Private, public;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User owner; //actual owner, the only allowed to delete for example
    @Column
    String status; //ex: completed, ongoing, dropped;
    @OneToMany(mappedBy = "project")
    List<Team> teams;

    public Projects(Long projectId, String projectName, LocalDate deadline, String desc, String visibility, User owner, String status, List<Team> teams) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.deadline = deadline;
        this.desc = desc;
        this.visibility = visibility;
        this.owner = owner;
        this.status = status;
        this.teams = teams;
    }
    public Projects(){}

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
