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
}
