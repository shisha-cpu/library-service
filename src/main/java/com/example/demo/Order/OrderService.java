package com.example.demo.Order;

import com.example.demo.Book.BookService;
import com.example.demo.User.UserService;

public class OrderService {
    private BookService bookService = new BookService();
    private UserService userService = new UserService();
    private OrderRepository repository;

    public Order getOrder(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Не удалось поличить order"));
    }

    public Order createOrder(Long bookId , Long userId){
        Order newOrder = new Order();
        newOrder.setBookId(bookId);
        newOrder.setUserId(userId);
        return repository.save(newOrder);
    }
}
