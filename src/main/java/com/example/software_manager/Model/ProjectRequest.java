/* package com.example.software_manager.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@Entity
public class ProjectRequest {
    @Column
    String projectName;
    @Column
    String projectDesc;
    @Column
    User userRequester; //Quem requisitou
    @Column
    User userRequested; //A quem requisitou
    @Column
    boolean accepted; //Se o requisitado aceitou o projeto
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long requestId;
    @Column
    List<Image> images; //umls, designs entre outros
}
*/