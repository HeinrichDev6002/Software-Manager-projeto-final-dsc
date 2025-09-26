package com.example.software_manager.Model;

import jakarta.persistence.*;
@Entity
public class ProjectImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String imageId;
    @Column
    String url;
    @Column
    String name; //UML, design, profile and etc;
    @ManyToOne
    @JoinColumn(name = "project_id")
    Projects project;
}
