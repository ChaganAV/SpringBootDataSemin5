package com.example.SptirngBootDataSemin5.controllers;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/tasks")
    public String findAll(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-update";
    }

    @PostMapping("/task-update/{id}")
    public String updateTask(@PathVariable Long id, @RequestBody Task task){
        taskService.updateTask(id,task);
        return "redirect:/tasks";
    }

    @GetMapping("/task-create")
    public String createTaskForm(Task task){
        return "task-create";
    }

    @PostMapping("/task-create")
    public String createTask(Task task){
        taskService.createTask(task);
        return "redirect:/tasks";
    }
}
