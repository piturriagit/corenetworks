package com.piturria.TasksWebApp.controller;

import com.piturria.TasksWebApp.model.BearerToken;
import com.piturria.TasksWebApp.model.MyTask;
import com.piturria.TasksWebApp.model.MyUser;
import com.piturria.TasksWebApp.service.JWTService;
import com.piturria.TasksWebApp.service.MyUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AuthController {

    private MyUserService service;

    public AuthController(MyUserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String  testing(HttpServletRequest request) {
        System.out.println("--------- GET / : ");
        return "Testing security " + request.getSession();
    }

    @PostMapping("/login")
    public ResponseEntity<BearerToken>  login(@RequestBody MyUser user) {
        if(service.verifyCredentials(user)) {
            BearerToken token = service.generateToken(user.getUsername());
            System.out.println("--------- POST /login: " + token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/register")
    public ResponseEntity<BearerToken> register(@RequestBody MyUser user) {
        try {
            if(service.findUser(user.getUsername()) == user)
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            service.register(user);
            BearerToken token = service.generateToken(user.getUsername());
            System.out.println("--------- POST /register: " + token);
            return new ResponseEntity<>(token, HttpStatus.OK);
        } catch (Exception e) {
            System.err.println("Not possible to register user: " + user.getUsername());
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}