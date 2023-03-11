package com.example.bookshop.dto.operation;

import com.example.bookshop.model.operation.Loan;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.time.LocalDate;

@JsonSerialize
@Getter
public class LoanListDTO {

    private String uid;
    private String bookUid;
    private String customerCpf;
    private LocalDate startDate;
    private LocalDate endDate;

    public LoanListDTO(Loan loan) {
        this.uid = loan.getUid();
        this.bookUid = loan.getBookUid();
        this.customerCpf = loan.getCustomerCpf();
        this.startDate = loan.getStartDate();
        this.endDate = loan.getEndDate();
    }
}
