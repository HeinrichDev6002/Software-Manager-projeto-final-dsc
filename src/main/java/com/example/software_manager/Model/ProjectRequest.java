package com.example.software_manager.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class ProjectRequest {
    String projectName;
    String projectDesc;
    User userRequester; //Quem requisitou
    User userRequested; //A quem requisitou
    boolean accepted; //Se o requisitado aceitou o projeto
    Long id;
    List<Image> images; //umls, designs entre outros
}
