package com.example.bookshop.service;

import com.example.bookshop.model.product.Book;
import com.example.bookshop.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<Book> all() {
        return bookRepository.findAllHQL();
    }
}
