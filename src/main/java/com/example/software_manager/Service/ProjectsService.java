package com.example.software_manager.Service;

import com.example.software_manager.Model.Projects;
import com.example.software_manager.Model.User;
import com.example.software_manager.Repository.ProjectsRepository;
import com.example.software_manager.Repository.TeamRepository;
import com.example.software_manager.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProjectsService {
   private final ProjectsRepository projectsRepository;
   private final UserRepository userRepository;
   private final TeamRepository teamRepository;

   public ProjectsService(ProjectsRepository repository, UserRepository userRepository, TeamRepository teamRepository){
       this.projectsRepository = repository;
       this.userRepository = userRepository;
       this.teamRepository = teamRepository;
   }
   public List<Projects> listProjects(){
       return projectsRepository.findAll();
   }
   public Projects findById(Long id){
       return projectsRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Project " + id + " não encontrada"));
   }
   public Projects createProject(Projects projects, Long userId){
       Optional<User> userOptional = userRepository.findById(userId);
       if(userOptional.isPresent()){
           projects.setOwner(userOptional.get());
           return projectsRepository.save(projects);
       }
       return null;
   }
   public Projects updateProject(Long id, Projects updates){
       Optional<Projects> projectsOptional = projectsRepository.findById(id);
       if(projectsOptional.isPresent()){
           Projects projects = projectsOptional.get();
           projects.setProjectName(updates.getProjectName());
           projects.setDeadline(updates.getDeadline());
           projects.setDesc(updates.getDesc());
           projects.setVisibility(updates.getVisibility());
           return projectsRepository.save(projects);
       }
       return null;
   }
   public void deleteProject(Long projectId){
       Optional<Projects> projectsOptional = projectsRepository.findById(projectId);
       if(projectsOptional.isPresent()){
           Projects projects = projectsOptional.get();
           projects.getTeams().stream().forEach(team -> {
               team.getUsers().removeAll(team.getUsers());
               teamRepository.save(team);
           });
           projectsRepository.save(projects);
           projectsRepository.delete(projects);
       }
   }
}
