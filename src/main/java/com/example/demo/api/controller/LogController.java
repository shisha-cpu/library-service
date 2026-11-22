package com.example.demo.api.controller;

import com.example.demo.api.dto.LogRequest;
import com.example.demo.application.service.LogService;
import com.example.demo.domain.model.Log;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    @Autowired
    private LogService logService;

    @PostMapping
    private void addLog(@Valid LogRequest log){
        logService.addLog(log);
    }

    @GetMapping
    private List<Log> getAllLogs(){
        return logService.getAllLogs();
    }

    @PostMapping("/{id}")
    private Log getLogById(@PathVariable Long id){
        return logService.getLogById(id);
    }

    @PostMapping("user/{userId}")
    private List<Log> getLogByUser(@PathVariable Long userId){
        return logService.getLogByUser(userId);
    }

    @PostMapping("book/{bookId}")
    private List<Log> getLogByBook(Long bookId){
        return logService.getLogByBook(bookId);
    }
}
