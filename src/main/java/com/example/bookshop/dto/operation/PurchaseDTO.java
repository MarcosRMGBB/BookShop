package com.example.bookshop.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class PurchaseDTO {
    private String uid;
    @NotBlank
    private String bookUid;
    @NotBlank
    private String customerCpf;
    private LocalDate date;

    public PurchaseDTO() {
        this.uid = UUID.randomUUID().toString();
        this.date = LocalDate.now();
    }
}

