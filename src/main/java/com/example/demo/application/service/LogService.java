package com.example.demo.application.service;

import com.example.demo.api.dto.LogRequest;
import com.example.demo.domain.model.Log;
import com.example.demo.domain.repository.BookRepository;
import com.example.demo.domain.repository.LogRepository;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    public void addLog(LogRequest req){
        Log newLog = new Log();
        newLog.setAction(req.getAction());
        newLog.setUser(userRepository.getReferenceById(req.getUserId()));
        newLog.setBook(bookRepository.getReferenceById(req.getBookId()));
        logRepository.save(newLog);
    }

    public List<Log> getAllLogs(){
        return logRepository.findAllWithDetails();
    }

    public Log getLogById(Long id){
        return logRepository.findById(id).orElseThrow();
    }

    public List<Log> getLogByUser(Long userId){
        return logRepository.findByUserIdWithDetails(userId);
    }

    public List<Log> getLogByBook(Long bookId){
        return logRepository.findByBookIdWithDetails(bookId);
    }
}
