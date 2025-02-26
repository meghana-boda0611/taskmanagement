package com.example.taskmanagement.service;

import com.example.taskmanagement.dto.TaskEntity;
import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskrepo;/*It was not declared as component/service to be autowired*/

    public void createTask(Task t){
        TaskEntity te=new TaskEntity();
        te.setId(t.getId());
        te.setTitle(t.getTitle());
        te.setDescription(t.getDescription());
        te.setStatus(t.getStatus());
        te.setCreatedAt(t.getCreatedAt());
        te.setUpdatedAt(t.getUpdatedAt());
//        BeanUtils.copyProperties(t, te);
        taskrepo.save(te);

    }

    public List<TaskEntity> getTasks(){
        return taskrepo.findAll();
    }

    public TaskEntity getTask(Long id){
        Optional<TaskEntity> optionalTask = taskrepo.findById(id);
        TaskEntity task = optionalTask.orElse(new TaskEntity());/*what is Optional here*/
        return task;
    }

    public void updateTask(Long id, Task t){
        TaskEntity te = getTask(id);
        te.setId(t.getId());
        te.setTitle(t.getTitle());
        te.setDescription(t.getDescription());
        te.setStatus(t.getStatus());
        te.setCreatedAt(t.getCreatedAt());
        te.setUpdatedAt(t.getUpdatedAt());
        taskrepo.save(te);

    }

    public void deleteTask(Long id){
        TaskEntity te=getTask(id);
        taskrepo.delete(te);


    }

}
