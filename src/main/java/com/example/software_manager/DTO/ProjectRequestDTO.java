package com.example.software_manager.DTO;

import com.example.software_manager.Model.Image;
import com.example.software_manager.Model.ProjectRequest;
import com.example.software_manager.Model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class ProjectRequestDTO {
    String projectName;
    String projectDesc;
    User userRequester; //Quem requisitou
    User userRequested; //A quem requisitou
    boolean accepted; //Se o requisitado aceitou o projeto
    Long id;
    List<Image> images;

    ModelMapper modelMapper;

    public ProjectRequestDTO toDTO(ProjectRequest projectRequest){
        return modelMapper.map(projectRequest, ProjectRequestDTO.class);
    }
}
