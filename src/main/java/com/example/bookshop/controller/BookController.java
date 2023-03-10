package com.example.bookshop.controller;

import com.example.bookshop.dto.BookDTO;
import com.example.bookshop.dto.BookListDTO;
import com.example.bookshop.model.product.Book;
import com.example.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody @Valid BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        bookRepository.save(book);
        return ResponseEntity
                .ok()
                .body(bookDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookListDTO>> list() {
        List<BookListDTO> bookListDTO = bookRepository.findAllHQL().stream()
                .map(BookListDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity
                .ok()
                .body(bookListDTO);
    }
}
