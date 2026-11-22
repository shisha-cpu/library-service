package com.example.demo.application.service;

import com.example.demo.api.dto.LogRequest;
import com.example.demo.domain.model.Log;
import com.example.demo.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void addLog(LogRequest log){
        Log newLog = new Log();
        newLog.setAction(log.getAction());
        newLog.setBookId(log.getBookId());
        newLog.setUserId(log.getUserId());
        logRepository.save(newLog);
    }

    public List<Log> getAllLogs(){
        return logRepository.findAll();
    }

    public Log getLogById(Long id){
        return logRepository.findById(id).orElseThrow();
    }

    public List<Log> getLogByUser(Long userId){
        return logRepository.findByUserId(userId);
    }

    public List<Log> getLogByBook(Long bookId){
        return logRepository.findByBookId(bookId);
    }
}
