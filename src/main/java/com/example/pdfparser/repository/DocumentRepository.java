package com.example.pdfparser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pdfparser.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {
    List<Document> findAll();

    <S extends Document> S save(S entity);

    @Query("update document u set u.author = ?2, u.status = ?3 where u.id = ?1")
    void update(Document entity);
}