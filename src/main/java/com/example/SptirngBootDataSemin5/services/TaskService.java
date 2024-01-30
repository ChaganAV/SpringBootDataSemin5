package com.example.SptirngBootDataSemin5.services;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    List<Task> findByStatus(TaskStatus status);
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long id);
}
