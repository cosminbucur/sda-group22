package com.sda.spring.boot.rest.controller;

import com.sda.spring.boot.rest.model.Book;
import com.sda.spring.boot.rest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api/v2/books")
@RestController
public class BookBetterController {

    private BookRepository bookRepository;

    @Autowired
    public BookBetterController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // TODO: implement using response entities
    /*
    GET /api/books
    POST /api/books

    GET /api/books/{id}
    PUT /api/books/{id}
    DELETE /api/books/{id}
     */

    @GetMapping
    public ResponseEntity<Book> findAll() {
        return null;
    }

}
