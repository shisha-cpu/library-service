package com.example.demo.domain.repository;

import com.example.demo.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre , Long> {
}
