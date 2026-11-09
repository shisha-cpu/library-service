package com.example.demo.api.controller;

import com.example.demo.api.dto.BookRequest;
import com.example.demo.api.dto.BookResponse;
import com.example.demo.application.service.BookService;
import com.example.demo.domain.model.Book;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> getBooks() {
        return service.getBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable Long id) {
        return service.getBookById(id);
    }

    @PostMapping
    public void addBook(@Valid BookRequest book) {
        service.addBook(book);
    }

    @PostMapping("/delete")
    public String deleteBook(Long id) {
        return service.deleteBook(id);
    }
}
