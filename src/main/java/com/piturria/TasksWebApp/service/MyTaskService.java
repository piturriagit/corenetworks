package com.piturria.TasksWebApp.service;

import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.repository.MyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyTaskService {

    @Autowired
    private MyTaskRepository repository;

//    //Constructor injection
//    public MyTaskService(MyTaskRepository repository) {
//        this.repository = repository;
//    }

    public List<MyTask> getAllTasks() {
        return repository.findAll();
    }

    public MyTask getTaskById(int id) {
        return repository.findById(id).orElse(null);
    }

    public MyTask addTask(MyTask task) {
        return repository.save(task);
    }

    public MyTask updateTask(int id, MyTask task) {
        if(getTaskById(id)==null)
            return null;
        task.setId(id);
        return repository.save(task);
    }

    public void deleteTaskById(int id) {
        repository.deleteById(id);
    }

    public void deleteAllTasks() {
        repository.deleteAll();
    }
}