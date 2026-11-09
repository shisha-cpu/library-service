package com.example.demo.Book;

import com.example.demo.Book.DTO.BookRequest;
import com.example.demo.Book.DTO.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private  BookRepository repository;

    public void addBook(BookRequest request){
        Book book = new Book();
        book.setName(request.getName());
        book.setReadTime(request.getReadTime());
        repository.save(book);
    }

    public List<Book> getBooks(){
        return  repository.findAll();
    }

    public BookResponse getBookById(Long id ){
        BookResponse response = new BookResponse();
        Book dbBook;

        dbBook = repository.findById(id).orElseThrow(()->new RuntimeException("Book не найден"));

        response.setName(dbBook.getName());
        response.setId(dbBook.getId());
        response.setReadTime(dbBook.getReadTime());
        return response;
    }

    public String deleteBook(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "Успех";
        }
        return "Нету такого";

    }


}
