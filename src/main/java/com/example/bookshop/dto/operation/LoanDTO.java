package com.example.bookshop.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
@Data
@AllArgsConstructor
public class LoanDTO {
    private String uid;
    @NotBlank
    private String bookUid;
    @NotBlank
    private String customerCpf;
    private LocalDate startDate;
    private LocalDate endDate;

    public LoanDTO() {
        this.uid = UUID.randomUUID().toString();
        this.startDate = LocalDate.now();
        this.endDate = LocalDate.now().plusDays(7);
    }
}
