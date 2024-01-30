package com.example.SptirngBootDataSemin5.controllers;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;
import com.example.SptirngBootDataSemin5.repositories.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * рест контроллер
 */
@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskRestController {
    private final TaskRepository taskRepository;

    /**
     * обрабатывает добавление задачи
     * @param task получает из тела запроса задачу
     * @return
     */
    @PostMapping
    public Task addTask(@RequestBody Task task){
        task.setDateBegin(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * выборка всех задач
     * @return
     */
    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    /**
     * получение задач по статусу
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return taskRepository.findByStatus(status);
    }

    /**
     * изменение задачи по ИД
     * @param id
     * @param task
     * @return
     */
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
