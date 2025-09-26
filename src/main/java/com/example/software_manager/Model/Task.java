package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long taskID;
    @Column
    String title;
    @Column
    String task; //A description about the task itself
    @Column
    String commentary; //Extra info
    @ManyToOne
    @JoinColumn(name = "task_id")
    Team team;
}
