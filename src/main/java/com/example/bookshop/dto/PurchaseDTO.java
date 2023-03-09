package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PurchaseDTO {
    String uid;
    String bookTitle;
    String customerCpf;

    public PurchaseDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
