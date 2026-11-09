package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    private UserRepository repository;

    public User getUserById(Long id){
        return repository.findById(id).orElseThrow(()-> new RuntimeException("Ошибка получения пользователя"));
    }

    public User createUser(User user){
        return repository.save(user);
    }

}
