package com.piturria.TasksWebApp.controller;

import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.model.MyUser;
import com.piturria.TasksWebApp.service.MyUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MyUserController {

    private MyUserService service;

    public MyUserController(MyUserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String  testing(HttpServletRequest request) {
        System.out.println("--------- GET / : ");
        return "Testing security " + request.getSession();
    }

    @PostMapping("/register")
    public ResponseEntity<MyUser> register(@RequestBody MyUser user) {
        System.out.println("--------- GET /register : " + user.getUsername());
        try {
            return new ResponseEntity<>(service.register(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}