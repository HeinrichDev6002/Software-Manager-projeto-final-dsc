package com.example.software_manager.Controller;

import com.example.software_manager.DTO.TeamDTO;
import com.example.software_manager.Model.Team;
import com.example.software_manager.Service.TeamService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v2")
public class TeamController {
    private final TeamService teamService;
    private  final ModelMapper modelMapper;

    public TeamController(TeamService teamService, ModelMapper modelMapper){
        this.teamService = teamService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = "/teams")
    public List<TeamDTO> getTeams(){
        List<Team> teams = teamService.listTeams();
        return teams.stream().map(team ->
            modelMapper.map(team, TeamDTO.class)).toList();
    }
    @GetMapping(path =  "/teams/{teamId")
    public TeamDTO getTeams(@PathVariable Long teamId){
        Team team = teamService.findById(teamId);
        return modelMapper.map(team, TeamDTO.class);
    }
    @PostMapping(path = "/project/{projectId}/teams")
    public TeamDTO createTeam(@PathVariable Long projectId, @RequestBody TeamDTO teamDTO){
        Team team = modelMapper.map(teamDTO, Team.class);
        Team teamCreated = teamService.createTeam(projectId, team);
        return modelMapper.map(teamCreated, TeamDTO.class);
    }
    @PutMapping(path = "/teams/{teamId}")
    public TeamDTO updateTeam(@PathVariable Long teamId, @RequestBody TeamDTO teamDTO){
        Team team = modelMapper.map(teamDTO, Team.class);
        Team teamUpdated = teamService.updateTeam(teamId, team);
        return modelMapper.map(teamUpdated, TeamDTO.class);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/teams/{teamId}")
    public void deleteTeam(@PathVariable Long teamId){
        teamService.deleteTeam(teamId);
    }

}
