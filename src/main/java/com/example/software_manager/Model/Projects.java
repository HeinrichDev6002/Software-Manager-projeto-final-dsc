package com.example.software_manager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class Projects {
    String projectName;
    String deadline;
    String projectId;
    String desc; //description
    Image img;
    String visibility; //Private, public;
    User owner; //actual owner, the only allowed to delete for example
    String status; //ex: completed, ongoing, dropped;
    List<User> contributors; //people who can help
}
