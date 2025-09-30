package com.example.software_manager.DTO;

import com.example.software_manager.Model.Projects;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
    private Long teamId;
    @NotBlank(message = "O nome não pode estar vazio")
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
