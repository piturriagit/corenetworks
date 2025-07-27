package com.piturria.TasksWebApp.controller;

import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.model.MyUser;
import com.piturria.TasksWebApp.service.MyUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyUserController {

    private MyUserService service;

    public MyUserController(MyUserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<MyUser> register(@RequestBody MyUser user) {
        System.out.println("--------- REGISTER : " + user.getUsername());
        try {
            return new ResponseEntity<>(service.register(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}