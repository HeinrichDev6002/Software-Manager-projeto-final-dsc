package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
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
    @OneToMany(mappedBy = "project")
    List<ProjectImage> images;
    @Column
    String visibility; //Private, public;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User owner; //actual owner, the only allowed to delete for example
    @Column
    String status; //ex: completed, ongoing, dropped;
    @OneToMany(mappedBy = "project")
    List<Team> teams;
}
