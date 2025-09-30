package com.example.software_manager.Controller;

import com.example.software_manager.DTO.ProjectDTO;
import com.example.software_manager.Model.Projects;
import com.example.software_manager.Service.ProjectsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v2")
public class ProjectController {
    private final ProjectsService projectsService;
    private final ModelMapper modelMapper;

    public ProjectController(ProjectsService projectsService, ModelMapper modelMapper) {
        this.projectsService = projectsService;
        this.modelMapper = modelMapper;
    }
    @GetMapping(path = "/projects")
    public List<ProjectDTO> getProjects(){
        List<Projects> projects = projectsService.listProjects();
        return projects.stream().map(project -> modelMapper.map(project, ProjectDTO.class)).toList();
    }
    @GetMapping(path = "/projects/{projectId}")
    public ProjectDTO getProjects(@PathVariable Long projectId){
        Projects projects = projectsService.findById(projectId);
        return modelMapper.map(projects, ProjectDTO.class);
    }
    @PostMapping(path = "/users/{userId}/projects")
    public ProjectDTO createProject(@PathVariable Long userId, @RequestBody ProjectDTO projectDTO){
        Projects projects = modelMapper.map(projectDTO, Projects.class);
        Projects projectCreated = projectsService.createProject(projects, userId);
        return modelMapper.map(projectCreated, ProjectDTO.class);
    }
    @PutMapping(path = "/projects/{projectId}")
    public ProjectDTO updateProject(@PathVariable Long projectId, @RequestBody ProjectDTO projectDTO){
        Projects projects = projectsService.findById(projectId);
        Projects projectUpdated = projectsService.updateProject(projectId, projects);
        return modelMapper.map(projectUpdated, ProjectDTO.class);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/projects/{projectId}")
    public void deleteProject(@PathVariable Long projectId){
        projectsService.deleteProject(projectId);
    }
}
