package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class LoanDTO {
    String uid;
    String bookTitle;
    String customerCpf;

    public LoanDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
