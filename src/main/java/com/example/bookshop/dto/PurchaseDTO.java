package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PurchaseDTO {
    private String uid;
    @NotBlank
    private String bookUid;
    @NotBlank
    private String customerCpf;

    public PurchaseDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}

