package com.example.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int readTime;

    public Book() {}

    public Book(Long id, String name, int readTime) {
        this.id = id;
        this.name = name;
        this.readTime = readTime;
    }

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
