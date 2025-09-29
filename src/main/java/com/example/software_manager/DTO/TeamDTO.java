package com.example.software_manager.DTO;

import com.example.software_manager.Model.Projects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long teamId;
    private String teamName;
    private Projects project;

    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", project=" + project +
                '}';
    }
}
