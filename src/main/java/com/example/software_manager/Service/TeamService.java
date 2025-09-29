package com.example.software_manager.Service;

import com.example.software_manager.Model.Projects;
import com.example.software_manager.Model.Team;
import com.example.software_manager.Repository.ProjectsRepository;
import com.example.software_manager.Repository.TeamRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class TeamService {
    private final TeamRepository teamRepository;
    private final ProjectsRepository projectsRepository;
    public TeamService(TeamRepository teamRepository, ProjectsRepository projectsRepository){
        this.teamRepository = teamRepository;
        this.projectsRepository = projectsRepository;
    }
    public List<Team> listTeams(){
        return teamRepository.findAll();
    }
    public Team findById(Long id){
        return teamRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Team " + id + " não encontrado"));
    }
    public Team createTeam(Long projectsId, Team team){
        Optional<Projects> projectsOptional = projectsRepository.findById(projectsId);
        if(projectsOptional.isPresent()){
            Projects projects = projectsOptional.get();
            team.setProject(projects);
            return teamRepository.save(team);
        }
        return null;
    }
    public Team updateTeam(Long id, Team updates){
        Optional<Team> teamOptional = teamRepository.findById(id);
        if(teamOptional.isPresent()){
            Team team = teamOptional.get();
            team.setTeamName(updates.getTeamName());
            return teamRepository.save(team);
        }
        return null;
    }
    public void deleteTeam(Long teamId){
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if(teamOptional.isPresent()){
            Team team = teamOptional.get();
            teamRepository.delete(team);
        }
    }
}
