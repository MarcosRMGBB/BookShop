package com.example.bookshop.controller;

import com.example.bookshop.dto.product.BookDTO;
import com.example.bookshop.dto.product.BookListDTO;
import com.example.bookshop.dto.product.BookUpdateDTO;
import com.example.bookshop.model.product.Book;
import com.example.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/new")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        bookRepository.save(book);
        return ResponseEntity
                .ok()
                .body(bookDTO);
    }
    @GetMapping("/list")
    public Page<BookListDTO> list(@PageableDefault(size = 5, sort = {"author"}) Pageable page) {
        return bookRepository.findAllByStatusTrue(page).map(BookListDTO::new);
    }
    @Transactional
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody BookUpdateDTO bookUpdateDTO) {
        Book book = bookRepository.getReferenceById(bookUpdateDTO.getId());
        book.updateData(bookUpdateDTO);
        BookDTO bookDTO = new BookDTO(book);
        return ResponseEntity
                .ok()
                .body(bookDTO);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Book book = bookRepository.getReferenceById(id);
        book.setStatus(false);
    }
}
