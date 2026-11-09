package com.example.demo.api.dto;

import jakarta.validation.constraints.NotBlank;

public class UserRequest {
    @NotBlank(message = "Имя пользователя - обязательно")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
