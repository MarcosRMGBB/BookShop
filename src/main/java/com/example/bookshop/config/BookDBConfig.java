package com.example.bookshop.config;

import com.example.bookshop.model.product.Book;
import com.example.bookshop.model.product.Category;
import com.example.bookshop.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
@AllArgsConstructor
public class BookDBConfig {
    private BookRepository bookRepository;

    @PostConstruct
    public void bookDB() {
        Book book1 = new Book();
        book1.setUid(UUID.randomUUID().toString());
        book1.setTitle("Dom Casmurro");
        book1.setAuthor("Machado de Assis");
        book1.setCategory(Category.LITERATURE);
        book1.setPrice(45.0);
        bookRepository.saveAndFlush(book1);
    }
}
