package com.example.demo.Book;

import com.example.demo.Book.DTO.BookRequest;
import com.example.demo.Book.DTO.BookResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService service;


    @GetMapping
    public List<Book> getBooks(){
        return  service.getBooks();
    }



    @PostMapping
    public void addBook(@Valid @RequestBody BookRequest book){
        service.addBook(book);
    }

    @PostMapping("/delete")
    public String deleteBook(Long id){
        return service.deleteBook(id);
    }

}
