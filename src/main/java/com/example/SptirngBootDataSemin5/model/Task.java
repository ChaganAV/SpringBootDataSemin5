package com.example.SptirngBootDataSemin5.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name="tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "description", length = 2000)
    private String Description;
    @Column(nullable = false, name = "status")
    private TaskStatus taskStatus;
    @Column(nullable = false, name = "date_begin")
    private LocalDateTime dateBegin;
}
