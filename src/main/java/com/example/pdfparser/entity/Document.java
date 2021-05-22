package com.example.pdfparser.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Table(name = "document")
public class Document {

    public Document() {
        super();
    }

    public Document(Long id, String author, String status) {
        super();
        this.id = id;
        Author = author;
        Status = status;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 100)
    private String Author;

    @Column(name = "status")
    private String Status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
