package com.example.demo.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookRequest {

    @NotBlank(message = "Название не может быть пустым")
    private String name;

    @Min(value = 1, message = "Время на чтение не менее 1")
    private int readTime;

    public String getName() {
        return name;
    }

    public int getReadTime() {
        return readTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }
}
