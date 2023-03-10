package com.example.bookshop.dto;

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

    public BookDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
