package com.example.demo.application.service;

import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Ошибка получения пользователя"));
    }

    public User createUser(User user) {
        return repository.save(user);
    }
}
