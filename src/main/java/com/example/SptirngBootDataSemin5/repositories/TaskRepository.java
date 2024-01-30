package com.example.SptirngBootDataSemin5.repositories;

import com.example.SptirngBootDataSemin5.model.Task;
import com.example.SptirngBootDataSemin5.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    //@Query("SELECT t FROM Tasks t WHERE t.status = ?1")
    List<Task> findByStatus(TaskStatus status);
}
