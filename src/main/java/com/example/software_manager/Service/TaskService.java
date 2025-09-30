package com.example.software_manager.Service;

import com.example.software_manager.Model.Task;
import com.example.software_manager.Model.Team;
import com.example.software_manager.Repository.TaskRepository;
import com.example.software_manager.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TeamRepository teamRepository;

    public TaskService(TaskRepository taskRepository, TeamRepository teamRepository){
        this.taskRepository = taskRepository;
        this.teamRepository = teamRepository;
    }
    public List<Task> listTasks(){
        return taskRepository.findAll();
    }
    public Task findById(Long id){
        return taskRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Task " + id + " não encontrada"));
    }
    public Task createTask(Long teamId, Task task){
        Optional<Team> teamOptional = teamRepository.findById(teamId);
        if(teamOptional.isPresent()){
            task.setTeam(teamOptional.get());
            return taskRepository.save(task);
        }
        return null;
    }
    public Task updateTask(Long id, Task updates){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            Task task = taskOptional.get();
            task.setTask(updates.getTask());
            task.setCommentary(updates.getCommentary());
            task.setTitle(updates.getTitle());
            return taskRepository.save(task);
        }
        return null;
    }
    public void deleteTask(Long taskId){
        Optional<Task> taskOptional = taskRepository.findById(taskId);
        if(taskOptional.isPresent()){
            Task task = taskOptional.get();
            taskRepository.delete(task);
        }
    }

}
