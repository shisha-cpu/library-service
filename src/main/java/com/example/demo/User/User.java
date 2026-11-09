package com.example.demo.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
//    TO DO
//    private List<Long> booksIds;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

}
