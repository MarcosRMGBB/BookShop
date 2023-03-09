package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class BookDTO {
    private String uid;
    private String title;
    private String author;
    private String category;
    private double price;

    public BookDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
