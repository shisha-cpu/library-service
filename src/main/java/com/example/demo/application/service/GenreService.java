package com.example.demo.application.service;

import com.example.demo.domain.model.Genre;
import com.example.demo.domain.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreService {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Long id;
    @Autowired
    private GenreRepository genreRepository;

    public Genre getGenreById(Long id){
        return genreRepository.findById(id).orElseThrow();
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public void createGenre(Genre genre){
        genreRepository.save(genre);
    }

}
