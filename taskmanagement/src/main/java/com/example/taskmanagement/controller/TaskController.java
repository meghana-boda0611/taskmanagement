package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.TaskEntity;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskservice;
    @PostMapping("/tasks")
    public void createTask(@RequestBody Task t){
        taskservice.createTask(t);

    }

    @GetMapping("/tasks")
    @PreAuthorize("hasRole('USER')")
    public List<TaskEntity> getTasks(@RequestParam (required = false) Long id){
        return taskservice.getTasks();
    }

    @GetMapping("/tasks/{id}")
    public TaskEntity getTaskid(@PathVariable Long id){
        return taskservice.getTask(id);

    }

    /*Understand difference between Request param, Path Variable and Response entity and request body*/

    @PutMapping("/tasks/{id}")
    public void putTask(@RequestBody Task t, @PathVariable Long id){
        taskservice.updateTask(id,t);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskservice.deleteTask(id);
    }

}





//Method	Endpoint	Description
//POST	/tasks	Create a new task
//GET	/tasks	Get all tasks
//GET	/tasks/{id}	Get task by ID
//PUT	/tasks/{id}	Update a task
//DELETE	/tasks/{id}	Delete a task