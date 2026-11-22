package com.example.demo.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public Integer fine;

    public String getName() {
        return name;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public Integer getFine() {
        return fine;
    }

    public User(Integer fine) {
        this.fine = 0;
    }
}
