package com.example.bookshop.dto;

import com.example.bookshop.model.product.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@AllArgsConstructor
@Data
public class BookDTO {
    private String uid;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Category category;
    private double price;

    public BookDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
