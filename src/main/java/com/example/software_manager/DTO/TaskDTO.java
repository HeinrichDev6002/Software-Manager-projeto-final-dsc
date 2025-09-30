package com.example.software_manager.DTO;

import com.example.software_manager.Model.Team;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private Long taskId;
    @NotBlank(message = "O título não pode estar vazio!")
    private String title;
    @NotBlank(message = "Tarefa não pode estar vazio!")
    private String task;
    private String comentary;
    private Team team;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", task='" + task + '\'' +
                ", comentary='" + comentary + '\'' +
                ", team=" + team +
                '}';
    }
}
