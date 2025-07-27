package com.piturria.TasksWebApp.service;

import com.piturria.TasksWebApp.model.MyUser;
import com.piturria.TasksWebApp.model.MyUserDetails;
import com.piturria.TasksWebApp.repository.MyUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private MyUserRepository repository;

    //Constructor injection
    public MyUserDetailsService(MyUserRepository repository) {this.repository = repository;}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = repository.findByUsername(username);

        if(user == null) {
            System.err.println("User not found");
            throw new UsernameNotFoundException("user not found: " + username);
        }
        return new MyUserDetails(user);
    }
}
