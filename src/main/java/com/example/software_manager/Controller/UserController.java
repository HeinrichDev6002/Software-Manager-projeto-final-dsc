package com.example.software_manager.Controller;

import com.example.software_manager.DTO.UserDTO;
import com.example.software_manager.Model.User;
import com.example.software_manager.Service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@Validated
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper = modelMapper;
    }
    @GetMapping(path = "/v2/users")
    public List<UserDTO> getUsers(){
        List<User> users = userService.listUsers();
        return users.stream().map(user ->
            modelMapper.map(user, UserDTO.class)).toList();
    }
    @GetMapping(path = "/v2/users/{userId}")
    public UserDTO getUsers(@PathVariable Long userId){
        User user = userService.findById(userId);
        return modelMapper.map(user, UserDTO.class);
    }
    @PostMapping(path = "/v2/users")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO){
        User u = modelMapper.map(userDTO, User.class);
        User userSaved = userService.create(u);
        return modelMapper.map(userSaved, UserDTO.class);
    }
    @PatchMapping(path = "/v2/teams/{teamId}/users/{userId}")
    public UserDTO team(@PathVariable Long teamId, @PathVariable Long userId){
        User user = userService.team(teamId, userId);
        return modelMapper.map(user, UserDTO.class);
    }
    @DeleteMapping(path = "/v2/teams/{teamId}/users/{userId}")
    public void unteam(@PathVariable Long teamId, @PathVariable Long userId){
        userService.unteam(teamId, userId);
    }
    @PutMapping(path = "/v2/users/{userId}")
    public UserDTO updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        User userUpdated = userService.updateUser(userId, user);
        return modelMapper.map(userUpdated, UserDTO.class);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
