package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String uid;
    private String name;
    private int age;
    private String cpf;

    public CustomerDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
