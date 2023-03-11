package com.example.bookshop.dto.product;

import com.example.bookshop.model.product.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
public class BookUpdateDTO {
    @NotBlank
    private long id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Double price;
}
