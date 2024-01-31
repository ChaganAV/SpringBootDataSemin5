package com.example.SptirngBootDataSemin5.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name="tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, name = "description", length = 2000)
    private String Description;
    //@Column(nullable = false, name = "status")
    //@Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @Column(nullable = false, name = "date_begin")
    private LocalDateTime dateBegin;

}
