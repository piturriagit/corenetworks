package com.piturria.TasksWebApp.service;

import com.piturria.TasksWebApp.model.MyUser;
import com.piturria.TasksWebApp.repository.MyUsersRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

    private MyUsersRepository repository;
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    //Constructor injection
    public MyUserService(MyUsersRepository repository, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.authenticationManager = authenticationManager;
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

    public String verify(MyUser user) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated())
            return "User verified: " + user;
        else
            return "Fail";  //unauthorized!! so never seen this
    }
}
