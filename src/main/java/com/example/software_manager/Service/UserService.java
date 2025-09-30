package com.example.software_manager.Service;

import com.example.software_manager.Model.Image;
import com.example.software_manager.Model.Projects;
import com.example.software_manager.Model.Team;
import com.example.software_manager.Model.User;
import com.example.software_manager.Repository.ImageRepository;
import com.example.software_manager.Repository.ProjectsRepository;
import com.example.software_manager.Repository.TeamRepository;
import com.example.software_manager.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Validated
public class UserService {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;
    private final ProjectsRepository projectsRepository;
    private final TeamRepository teamRepository;

    public UserService(UserRepository userRepository, ImageRepository imageRepository, ProjectsRepository projectsRepository, TeamRepository teamRepository){
        this.userRepository = userRepository;
        this.imageRepository = imageRepository;
        this.projectsRepository = projectsRepository;
        this.teamRepository = teamRepository;
    }
    public List<User> listUsers(){
        return userRepository.findAll();
    }
    public User create(@Valid User user){
        Image image = new Image();
        image.setUrl("www.example/image.png");
        imageRepository.save(image);
        user.setUserImage(image);
        return userRepository.save(user);
    }
    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Não encontrado"));
    }
    public User updateUser(Long id, @Valid User update){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setUserEmail(update.getUserEmail());
            user.setUserName(update.getUserName());
            return userRepository.save(user);
        }
        return null;
    }
    public User team(Long teamId, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if(userOptional.isPresent() && teamOptional.isPresent()){
            User user = userOptional.get();
            user.getTeams().add(teamOptional.get());
            return userRepository.save(user);
        }
        return null;
    }
    public User unteam(Long teamId, Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if(userOptional.isPresent() && teamOptional.isPresent()){
            User user = userOptional.get();
            user.getTeams().remove(teamOptional.get());
            return userRepository.save(user);
        }
        return null;
    }
    public void deleteUser(Long userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.getTeams().removeAll(user.getTeams());
            List<Projects> projects = user.getProjects();
            projects.stream().forEach(projects1 -> {
                projects1.getTeams().removeAll(projects1.getTeams());
                projectsRepository.save(projects1);
            });
            userRepository.save(user);
            userRepository.delete(user);
        }
    }
}
