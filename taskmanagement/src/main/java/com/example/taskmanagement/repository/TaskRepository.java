package com.example.taskmanagement.repository;

import com.example.taskmanagement.dto.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {



}
