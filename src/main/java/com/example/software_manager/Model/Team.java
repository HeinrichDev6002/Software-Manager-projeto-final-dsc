package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long teamId;
    @Column
    String teamName;
    @ManyToMany
    @JoinTable(name = "compartilhamento",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users;
    @ManyToOne
    @JoinColumn(name = "project_id")
    Projects project;
    @OneToMany(mappedBy = "team")
    List<Task> tasks;

    public Team(Long teamId, String teamName, List<User> users, Projects project, List<Task> tasks) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.users = users;
        this.project = project;
        this.tasks = tasks;
    }
    public Team(){}

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
