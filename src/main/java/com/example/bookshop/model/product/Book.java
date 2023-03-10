package com.example.bookshop.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="book")
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

    public Book() {
        this.uid = UUID.randomUUID().toString();
    }
}
