package com.example.demo.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private  UserService service;

    @GetMapping
    private User getUser(Long id){
        return service.getUserById(id);
    }
    @PostMapping
    private User createUser(User user){
        return service.createUser(user);
    }
}
