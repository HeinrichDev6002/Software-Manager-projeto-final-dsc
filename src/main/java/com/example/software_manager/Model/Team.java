package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
}
