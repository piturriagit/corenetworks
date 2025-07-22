package com.piturria.TasksWebApp.controller;

import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.service.MyTaskService;
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
        return service.getAllTasks();
    }

    @GetMapping("/task")
    public MyTask getTaskById(@RequestParam("id") int id) {
        System.out.println("--------- GET /task?id=" + id);
        return service.getTaskById(id);
    }

    @PostMapping("/task")
    public MyTask addTask(@RequestBody MyTask task) {
        System.out.println("--------- POST /task: " + task);
        return service.addTask(task);
    }

    @PutMapping("/task")
    public MyTask updateTask(@RequestParam("id") int id, @RequestBody MyTask task) {
        System.out.println("--------- PUT /task?id=" + id +" : " + task);
        return service.updateTask(id, task);
    }

    @DeleteMapping("/task")
    public boolean deleteTaskById(@RequestParam("id") int id) {
        System.out.println("--------- DELETE /task?id=" + id);
        return service.deleteTaskById(id);
    }

    @DeleteMapping("/tasks")
    public void deleteAllTasks() {
        System.out.println("--------- DELETE /tasks");
        service.deleteAllTasks();
    }
}
