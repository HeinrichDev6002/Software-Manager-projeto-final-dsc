package com.example.software_manager.Controller;

import com.example.software_manager.DTO.TaskDTO;
import com.example.software_manager.Model.Task;
import com.example.software_manager.Service.TaskService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
@Validated
public class TaskController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(TaskService taskService, ModelMapper modelMapper){
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }
    @GetMapping(path = "/tasks")
    public List<TaskDTO> getTasks(){
        List<Task> tasks = taskService.listTasks();
        return tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class)).toList();
    }
    @GetMapping(path = "/tasks/{taskId}")
    public TaskDTO getTask(@PathVariable Long taskId){
        Task task = taskService.findById(taskId);
        return modelMapper.map(task, TaskDTO.class);
    }
    @PostMapping(path = "/teams/{teamId}/tasks")
    public TaskDTO createTask(@PathVariable Long teamId, @Valid @RequestBody TaskDTO taskDTO){
        Task task = modelMapper.map(taskDTO, Task.class);
        Task taskCreated = taskService.createTask(teamId, task);
        return modelMapper.map(taskCreated, TaskDTO.class);
    }
    @PutMapping(path = "/tasks/{taskId}")
    public TaskDTO updateTask(@PathVariable Long taskId, @Valid @RequestBody TaskDTO taskDTO){
        Task task = modelMapper.map(taskDTO, Task.class);
        Task taskUpdated = taskService.updateTask(taskId, task);
        return modelMapper.map(taskUpdated, TaskDTO.class);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(path = "/task/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }
}
