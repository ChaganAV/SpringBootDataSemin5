package com.example.SptirngBootDataSemin5.services;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    //List<Task> findByStatus(TaskStatus status);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
}
