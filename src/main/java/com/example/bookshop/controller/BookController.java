package com.example.bookshop.controller;

import com.example.bookshop.dto.BookDTO;
import com.example.bookshop.model.product.Book;
import com.example.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        bookRepository.save(book);
        return ResponseEntity
                .ok()
                .body(bookDTO);
    }
}
