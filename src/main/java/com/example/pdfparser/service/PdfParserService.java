package com.example.pdfparser.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;

import com.example.pdfparser.entity.Document;
import com.example.pdfparser.model.DocumentModel;
import com.example.pdfparser.repository.DocumentRepository;

@Service
public class PdfParserService {

    private DocumentRepository documentRepository;

    public PdfParserService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<Document> getAllDocs() {
        return documentRepository.findAll();
    }

    public void saveDocument() throws InvalidPasswordException, IOException {
        System.out.println("Inside Service");
        try (PDDocument document = PDDocument
                .load(new File("C:\\TAA_Code_Games\\Sample Projects\\IntelliConnect.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                // System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }

            }

        }

    }

    public void saveDoc(DocumentModel documentModel) {
        System.out.println("Inside Save Doc Service");
        documentRepository
                .save(new Document(documentModel.getId(), documentModel.getAuthor(), documentModel.getStatus()));
    }

    public void updateDoc(DocumentModel documentModel) {
        System.out.println("Inside Update Doc Service");
        documentRepository.update(
                new Document(documentModel.getId(), documentModel.getAuthor(), documentModel.getStatus()));
    }

}
