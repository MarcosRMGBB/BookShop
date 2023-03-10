package com.example.bookshop.dto;

import com.example.bookshop.model.product.Book;
import com.example.bookshop.model.product.Category;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
@JsonSerialize
@Getter
public class BookListDTO {
    private String uid;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;
    public BookListDTO(Book book) {
        this.uid = book.getUid();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.category = book.getCategory();
        this.price = book.getPrice();
    }
}
