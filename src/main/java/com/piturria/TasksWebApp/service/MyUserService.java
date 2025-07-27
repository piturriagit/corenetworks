package com.piturria.TasksWebApp.service;

import com.piturria.TasksWebApp.model.MyUser;
import com.piturria.TasksWebApp.repository.MyUsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

    private MyUsersRepository repository;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public MyUserService(MyUsersRepository repository) {
        this.repository = repository;
    }

    public MyUser register(MyUser user) throws Exception {

        //NOT ENCODED PASSWORD
        //user.setPassword(user.getPassword());

        //ENCODED PASSWORD
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            return repository.save(user);
        } catch (Exception e) {
            System.out.println("Error during register (" + user.getUsername() + "): " + e.getMessage());
            throw new Exception();
        }
    }
}
