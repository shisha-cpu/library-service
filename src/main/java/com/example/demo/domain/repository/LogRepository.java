package com.example.demo.domain.repository;

import com.example.demo.domain.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByUserId(Long userId);
    List<Log> findByBookId(Long bookId);
}
