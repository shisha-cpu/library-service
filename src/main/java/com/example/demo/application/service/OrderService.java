package com.example.demo.application.service;

import com.example.demo.api.dto.LogRequest;
import com.example.demo.domain.model.Log;
import com.example.demo.domain.model.Order;
import com.example.demo.domain.model.User;
import com.example.demo.domain.repository.BookRepository;
import com.example.demo.domain.repository.LogRepository;
import com.example.demo.domain.repository.OrderRepository;
import com.example.demo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
    @Autowired
    private LogService logService;

    public Order getOrder(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Не удалось получить order"));
    }

    public Order createOrder(Long bookId, Long userId) {
        Order newOrder = new Order("Created");
        newOrder.setBookId(bookId);
        newOrder.setUserId(userId);

        Log newLog = new Log();
        newLog.setUser(userRepository.getReferenceById(userId));
        newLog.setBook(bookRepository.getReferenceById(bookId));
        newLog.setAction("Order book");
        logRepository.save(newLog);

        return repository.save(newOrder);
    }

    public String closeOrder(Long orderId){
        Order order = repository.findById(orderId).orElseThrow();
        Date orderStartTime = order.getCreatedDate();
        LogRequest newLog = new LogRequest();
        newLog.setUserId(order.getUserId());
        newLog.setBookId(order.getBookId());
        LocalDate orderDate = orderStartTime.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate now = LocalDate.now();

        long daysBetween = ChronoUnit.DAYS.between(orderDate, now);

        if (daysBetween >= 14) {
            newLog.setAction("Заказ закрыт");
            logService.addLog(newLog );
            order.setStatus("Закрыта");
            return "Заказ закрыт";

        } else {
            newLog.setAction("Штраф!");
            logService.addLog(newLog);
            User user = userService.getUserById(order.getUserId());
            Integer currentFine = user.getFine() != null ? user.getFine() : 0;
            user.setFine(currentFine + 100 );
            userRepository.save(user);
            return "Штрафт 100";
        }
    }

}
