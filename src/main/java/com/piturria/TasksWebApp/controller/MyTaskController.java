package com.piturria.TasksWebApp.controller;

import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.service.MyTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin        //allows different address/port to request this api: for angular
public class MyTaskController {

    private MyTaskService service;

    //Constructor injection
    public MyTaskController(MyTaskService service) {
        this.service = service;
    }

    @GetMapping("/v1.0/tasks")
    public ResponseEntity<List<MyTask>> getAllTasks() {
        System.out.println("--------- GET /v1.0/tasks");
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/v1.0/tasks/{id}")
    public ResponseEntity<MyTask> getTaskById(@PathVariable int id) {
        System.out.println("--------- GET /v1.0/tasks/" + id);
        MyTask task=service.getTaskById(id);
        if(task == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping("/v1.0/tasks")
    public ResponseEntity<MyTask> addTask(@RequestBody MyTask task) {
        System.out.println("--------- POST /v1.0/tasks : " + task);
        MyTask result;
        return new ResponseEntity<>(service.addTask(task),HttpStatus.CREATED);
    }

    @PutMapping("/v1.0/tasks/{id}")
    public ResponseEntity<MyTask> updateTask(@PathVariable int id, @RequestBody MyTask task) {
        System.out.println("--------- PUT /v1.0/tasks/" + id +" : " + task);
        MyTask editedTask=service.updateTask(id, task);
        if(editedTask == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(editedTask,HttpStatus.OK);
    }

    @DeleteMapping("/v1.0/tasks/{id}")
    public ResponseEntity<HttpStatus> deleteTaskById(@PathVariable int id) {
        System.out.println("--------- DELETE /v1.0/tasks/" + id);
        service.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/v1.0/tasks")
    public ResponseEntity<HttpStatus> deleteAllTasks() {
        System.out.println("--------- DELETE /v1.0/tasks");
        service.deleteAllTasks();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
