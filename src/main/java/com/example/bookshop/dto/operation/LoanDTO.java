package com.example.bookshop.dto.operation;

import com.example.bookshop.model.operation.Loan;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
    public LoanDTO(Loan loan) {
        this.uid = loan.getUid();
        this.bookUid = loan.getBookUid();
        this.customerCpf = loan.getCustomerCpf();
        this.startDate = loan.getStartDate();
        this.endDate = loan.getEndDate();
    }
}
