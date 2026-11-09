package com.example.demo.api.controller;

import com.example.demo.application.service.OrderService;
import com.example.demo.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return service.getOrder(id);
    }

    @PostMapping
    public Order createOrder(@RequestParam Long bookId, @RequestParam Long userId) {
        return service.createOrder(bookId, userId);
    }
}
