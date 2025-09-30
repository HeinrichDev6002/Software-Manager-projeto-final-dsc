package com.example.software_manager.DTO;

import com.example.software_manager.Model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {
    private Long projectId;
    @NotBlank(message = "Nome não pode estar vazio")
    private String projectName;
    private LocalDate deadline;
    private String desc;
    private String visibility;
    private User owner;
    private String status;

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", deadline=" + deadline +
                ", desc='" + desc + '\'' +
                ", visibility='" + visibility + '\'' +
                ", owner=" + owner +
                ", status='" + status + '\'' +
                '}';
    }
}
