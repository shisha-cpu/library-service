package com.example.demo.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Long user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Long book;

    @NotNull
    private String action;

    @CreationTimestamp
    private Date logTime;

    public Long getId() {
        return id;
    }

    public Date getLogTime() {
        return logTime;
    }

    public String getAction() {
        return action;
    }




    public void setAction(String action) {
        this.action = action;
    }
}
