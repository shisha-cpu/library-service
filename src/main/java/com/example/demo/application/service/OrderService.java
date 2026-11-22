package com.example.demo.application.service;

import com.example.demo.domain.model.Log;
import com.example.demo.domain.model.Order;
import com.example.demo.domain.repository.BookRepository;
import com.example.demo.domain.repository.LogRepository;
import com.example.demo.domain.repository.OrderRepository;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderRepository repository;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    public Order getOrder(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Не удалось получить order"));
    }

    public Order createOrder(Long bookId, Long userId) {
        Order newOrder = new Order();
        newOrder.setBookId(bookId);
        newOrder.setUserId(userId);

        Log newLog = new Log();
        newLog.setUser(userRepository.getReferenceById(userId));
        newLog.setBook(bookRepository.getReferenceById(bookId));
        newLog.setAction("Order book");
        logRepository.save(newLog);

        return repository.save(newOrder);


    }
}
