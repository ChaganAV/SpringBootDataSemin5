package com.example.SptirngBootDataSemin5.controllers;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;
import com.example.SptirngBootDataSemin5.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskRestController {
    private final TaskRepository taskRepository;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setDateBegin(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        Task testTask = taskRepository.findById(id).orElse(null);
        if(testTask != null){
            testTask.setTaskStatus(task.getTaskStatus());
            return taskRepository.save(testTask);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
