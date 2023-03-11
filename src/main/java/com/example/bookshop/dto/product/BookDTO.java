package com.example.bookshop.dto.product;

import com.example.bookshop.model.product.Book;
import com.example.bookshop.model.product.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@AllArgsConstructor
@Data
public class BookDTO {
    private String uid;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    private double price;
    private boolean status;

    public BookDTO() {
        this.uid = UUID.randomUUID().toString();
    }

    public BookDTO(Book book) {
        this.uid = book.getUid();
        this.author = book.getAuthor();
        this.category = book.getCategory();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.status = book.isStatus();
    }
}
