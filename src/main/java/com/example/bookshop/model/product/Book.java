package com.example.bookshop.model.product;

import com.example.bookshop.dto.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.rmi.server.UID;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="book")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String uid;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;

    public Book(BookDTO bookDTO) {
        this.uid = UUID.randomUUID().toString();
        this.title = bookDTO.getTitle();
        this.author = bookDTO.getAuthor();
        this.category = bookDTO.getCategory();
        this.price = bookDTO.getPrice();
    }
}
