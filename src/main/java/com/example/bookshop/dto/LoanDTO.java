package com.example.bookshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;
@Data
@AllArgsConstructor
public class LoanDTO {
    private String uid;
    @NotBlank
    private String bookUid;
    @NotBlank
    private String customerCpf;

    public LoanDTO() {
        this.uid = UUID.randomUUID().toString();
    }
}
