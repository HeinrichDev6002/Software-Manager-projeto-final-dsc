package com.example.software_manager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String userName;
    String userEmail;
    String userId;
    String password;
    List<Projects> projects;
}
