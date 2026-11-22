package com.example.demo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LogRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long bookId;
    @NotBlank
    private String action;


    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getAction() {
        return action;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
