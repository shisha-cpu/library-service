package com.example.demo.application.service;

import com.example.demo.api.dto.BookRequest;
import com.example.demo.api.dto.BookResponse;
import com.example.demo.domain.model.Book;
import com.example.demo.domain.model.BookDocument;
import com.example.demo.domain.model.Genre;
import com.example.demo.domain.model.Log;
import com.example.demo.domain.repository.BookDocumentRepository;
import com.example.demo.domain.repository.BookRepository;
import com.example.demo.domain.repository.GenreRepository;
import com.example.demo.domain.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private BookDocumentRepository bookDocumentRepository;

    public void addBook(BookRequest request) {
        Genre genre = genreRepository.findById(request.getGenre()).orElseThrow(()-> new RuntimeException("Жанр не найден"));
        Book book = new Book();
        book.setName(request.getName());
        book.setReadTime(request.getReadTime());
        book.setGenre(genre);
        bookRepository.save(book);

        BookDocument doc = new BookDocument();
        doc.setName(request.getName());
        doc.setReadTime(request.getReadTime());
        doc.setGenreName(genre.getName());
        bookDocumentRepository.save(doc);
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public BookResponse getBookById(Long id) {
        BookResponse response = new BookResponse();
        Book dbBook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book не найден"));

        response.setName(dbBook.getName());
        response.setId(dbBook.getId());
        response.setReadTime(dbBook.getReadTime());
        return response;
    }

    public String deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "Успех";
        }
        return "Нету такого";
    }

    public List<BookDocument> findByName(String query){
        return bookDocumentRepository.findByName(query);
    }

}
