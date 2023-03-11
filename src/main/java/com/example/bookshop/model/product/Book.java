package com.example.bookshop.model.product;

import com.example.bookshop.dto.product.BookDTO;
import com.example.bookshop.dto.product.BookUpdateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private boolean status;

    public Book(BookDTO bookDTO) {
        this.uid = bookDTO.getUid();
        this.title = bookDTO.getTitle();
        this.author = bookDTO.getAuthor();
        this.category = bookDTO.getCategory();
        this.price = bookDTO.getPrice();
        this.status = true;
    }

    public void updateData(BookUpdateDTO bookUpdateDTO) {
        if (bookUpdateDTO.getAuthor() != null) {
            this.author = bookUpdateDTO.getAuthor();
        }
        if (bookUpdateDTO.getCategory() != null) {
            this.category = bookUpdateDTO.getCategory();
        }
        if (bookUpdateDTO.getTitle() != null) {
            this.title = bookUpdateDTO.getTitle();
        }
        if (bookUpdateDTO.getPrice() != null) {
            this.price = bookUpdateDTO.getPrice();
        }
    }
}
