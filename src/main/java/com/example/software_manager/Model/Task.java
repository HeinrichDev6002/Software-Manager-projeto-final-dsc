package com.example.software_manager.Model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long taskId;
    @Column
    String title;
    @Column
    String task; //A description about the task itself
    @Column
    String commentary; //Extra info
    @ManyToOne
    @JoinColumn(name = "team_id")
    Team team;

    public Task(Long taskID, String title, String task, String commentary, Team team) {
        this.taskId = taskID;
        this.title = title;
        this.task = task;
        this.commentary = commentary;
        this.team = team;
    }
    public Task(){}

    public Long getTaskID() {
        return taskId;
    }

    public void setTaskID(Long taskID) {
        this.taskId = taskID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
