package com.example.SptirngBootDataSemin5.controllers;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    /**
     * интерфейс сервиса
     */
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * вывод домашней странички
     * @return
     */
    @GetMapping("/")
    public String home(){
        return "home";
    }

    /**
     * выборка всех задач
     * @param model модель для передачи в представление
     * @return представление задач
     */
    @GetMapping("/tasks")
    public String findAll(Model model){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    /**
     * переход на форму изменения данных
     * @param id ид задачи
     * @param model модель для представления
     * @return страница для заполнения
     */
    @GetMapping("/task-update/{id}")
    public String updateTaskForm(@PathVariable("id") Long id, Model model){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "task-update";
    }

    /**
     * пост метод для изменения и перехода на страницу списка задач
     * @param task задача полученная из формы
     * @return переходим на страницу списка задач
     */
    @PostMapping("/task-update")
    public String updateTask(@ModelAttribute("task") Task task){
        taskService.updateTask(task);
        return "redirect:/tasks";
    }

    /**
     * метод перехода на страницу добавления задачи
     * @param task задача
     * @return страница с формой добавления
     */
    @GetMapping("/task-create")
    public String createTaskForm(Task task){
        return "task-create";
    }

    /**
     * пост метод, после заполнения формы создаем задачу и переходим к списку задач
     * @param task задача
     * @return представление списка задач
     */
    @PostMapping("/task-create")
    public String createTask(Task task){
        taskService.createTask(task);
        return "redirect:/tasks";
    }
    @GetMapping("/task-delete/{id}")
    public String deleteTask(@PathVariable("id") Long id, Model model){
        taskService.deleteTask(id);
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
}
