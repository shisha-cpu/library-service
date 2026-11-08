package com.example.demo.Book.DTO;

public class BookResponse {
    private Long id;
    private String name;
    private int readTime;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReadTime() {
        return readTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }
}
