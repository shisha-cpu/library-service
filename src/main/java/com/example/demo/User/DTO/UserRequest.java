package com.example.demo.User.DTO;

import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank( message = "Имя пользователя - обязательно")
    private String name;
}
