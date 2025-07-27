package com.piturria.TasksWebApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class MyUserController {
    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        System.out.println("--------- GET /");
        return "Wellcome to Piturria " + request.getSession().getId();
    }
}
