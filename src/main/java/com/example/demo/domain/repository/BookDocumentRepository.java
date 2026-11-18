package com.example.demo.domain.repository;

import com.example.demo.domain.model.BookDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookDocumentRepository extends ElasticsearchRepository<BookDocument, Long> {
    List<BookDocument> findByName(String name);
}

