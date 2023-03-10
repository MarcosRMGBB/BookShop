package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@Data
@AllArgsConstructor
public class LoanDTO {
    private String uid;
    private String bookUid;
    private String customerCpf;

    public LoanDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
