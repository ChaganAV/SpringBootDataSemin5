package com.example.SptirngBootDataSemin5.services;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;
import com.example.SptirngBootDataSemin5.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> findByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task createTask(Task task) {
        task.setTaskStatus(TaskStatus.NOT_STARTED);
        task.setDateBegin(LocalDateTime.now());
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        Task existTask = getTaskById((long)task.getId());
        existTask.setDescription(task.getDescription());
        existTask.setDateBegin(LocalDateTime.now());
        return taskRepository.save(existTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = getTaskById(id);
        if (task != null)
            taskRepository.deleteById(id);
    }
}
