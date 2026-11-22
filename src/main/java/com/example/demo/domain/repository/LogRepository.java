package com.example.demo.domain.repository;

import com.example.demo.domain.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Long> {
    List<Log> findByUserId(Long userId);
    List<Log> findByBookId(Long bookId);


    @Query("select l from Log l join fetch l.user join fetch l.book")
    List<Log> findAllWithDetails();

    @Query("select l from Log l join fetch l.user join fetch l.book where l.user.id = :userId")
    List<Log> findByUserIdWithDetails( Long userId);

    @Query("select l from Log l join fetch l.user join fetch l.book where l.book.id = :bookId")
    List<Log> findByBookIdWithDetails( Long bookId);
}
