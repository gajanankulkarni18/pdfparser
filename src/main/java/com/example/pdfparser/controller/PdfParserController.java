package com.example.pdfparser.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlProcessor.DocumentMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.pdfparser.entity.Document;
import com.example.pdfparser.model.DocumentModel;
import com.example.pdfparser.service.PdfParserService;

import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
@RestController
@RequestMapping("/")
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
public class PdfParserController {

    @Autowired
    PdfParserService pdfParserService;
    
    @GetMapping("docs")
    public List<DocumentModel> getAllDocs() {
        List<Document> docs = pdfParserService.getAllDocs();
        List<DocumentModel> docModels = new ArrayList<DocumentModel>();
        docs.stream().forEach((doc) ->{
            DocumentModel docModel = new DocumentModel();
            docModel.setId(doc.getId());
            docModel.setAuthor(doc.getAuthor());
            docModel.setStatus(doc.getStatus());
            docModels.add(docModel);
        });
       return docModels;
      }
    
    @PostMapping("docs")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus saveDoc(@RequestBody DocumentModel documentModel) {
        pdfParserService.saveDoc(documentModel);
        return HttpStatus.OK;
      }
    
    
    @PutMapping("docs")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus updateDoc(@RequestBody DocumentModel documentModel) {
        pdfParserService.updateDoc(documentModel);
        return HttpStatus.OK;
      }
    
    @GetMapping("parse")
    public String saveDocument() throws InvalidPasswordException, IOException {
        System.out.println("PDF parser Started");
        pdfParserService.saveDocument();
        return "";
    }
}
