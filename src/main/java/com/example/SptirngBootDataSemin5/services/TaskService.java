package com.example.SptirngBootDataSemin5.services;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * сервис методов задач
 */
@Service
public interface TaskService {
    /**
     * все задачи
     * @return список задач
     */
    List<Task> getAllTasks();

    /**
     * получение задач по ID
     * @param id
     * @return список задач
     */
    Task getTaskById(Long id);

    /**
     * выборка задач по статусу задачи
     * @param status статус задачи
     * @return список задач
     */
    List<Task> findByStatus(TaskStatus status);

    /**
     * создание задачи
     * @param task задача
     * @return
     */
    Task createTask(Task task);

    /**
     * изменение задачи
     * @param task
     * @return
     */
    Task updateTask(Task task);

    /**
     * удаление задачи
     * @param id
     */
    void deleteTask(Long id);
}
