package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PurchaseDTO {
    private String uid;
    private String bookUid;
    private String customerCpf;

    public PurchaseDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}

