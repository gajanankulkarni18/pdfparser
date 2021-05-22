package com.example.pdfparser.model;

import lombok.Getter;
import lombok.Setter;

public class DocumentModel {

    @Getter @Setter
    Long id;

    @Getter @Setter
    String author;

    @Getter @Setter
    String status;
}
