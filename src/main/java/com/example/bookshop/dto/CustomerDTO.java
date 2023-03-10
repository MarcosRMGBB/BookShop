package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String uid;
    @NotBlank
    private String name;
    @NotNull
    private int age;
    @NotBlank
    private String cpf;

    public CustomerDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
