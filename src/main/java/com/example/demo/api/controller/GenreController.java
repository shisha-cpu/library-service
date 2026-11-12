package com.example.demo.api.controller;

import com.example.demo.application.service.GenreService;
import com.example.demo.domain.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping("/{id}")
    private Genre getGenre(@PathVariable Long id){
      return  genreService.getGenreById(id);
    }
    @GetMapping("/all")
    private List<Genre> getAllGenre(){
        return genreService.getAllGenres();
    }
    @PostMapping
    private void setGenre(Genre genre){
        genreService.createGenre(genre);
    }
}
