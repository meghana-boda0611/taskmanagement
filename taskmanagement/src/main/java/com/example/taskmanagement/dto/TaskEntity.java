package com.example.taskmanagement.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "tasks")
public class TaskEntity {
    @Id
    private Long id;

    private String title;

    private String description;
    private String status;
    @Column(name = "\"createdAt\"")
    private LocalDateTime createdAt;
    @Column(name = "\"updatedAt\"")
    private LocalDateTime updatedAt;

    // Getters and Setters
}
