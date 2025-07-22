package com.piturria.TasksWebApp.controller;

import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.service.MyTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyTaskController {

    private MyTaskService service;

    //Constructor injection
    public MyTaskController(MyTaskService service) {
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<MyTask>> getAllTasks() {
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/task")
    public ResponseEntity<MyTask> getTaskById(@RequestParam("id") int id) {
        System.out.println("--------- GET /task?id=" + id);
        MyTask task=service.getTaskById(id);
        if(task == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/task")
    public ResponseEntity<MyTask> addTask(@RequestBody MyTask task) {
        System.out.println("--------- POST /task: " + task);
        MyTask result;
        return new ResponseEntity<>(service.addTask(task),HttpStatus.CREATED);
    }

    @PutMapping("/task")
    public ResponseEntity<MyTask> updateTask(@RequestParam("id") int id, @RequestBody MyTask task) {
        System.out.println("--------- PUT /task?id=" + id +" : " + task);
        MyTask editedTask=service.updateTask(id, task);
        if(editedTask == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(editedTask,HttpStatus.OK);
    }

    @DeleteMapping("/task")
    public ResponseEntity<Boolean> deleteTaskById(@RequestParam("id") int id) {
        System.out.println("--------- DELETE /task?id=" + id);
        if(service.deleteTaskById(id))
            return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<?> deleteAllTasks() {
        System.out.println("--------- DELETE /tasks");
        service.deleteAllTasks();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
