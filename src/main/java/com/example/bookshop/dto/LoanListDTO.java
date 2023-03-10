package com.example.bookshop.dto;

import com.example.bookshop.model.operations.Loan;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@JsonSerialize
@Getter
public class LoanListDTO {

    private String uid;
    private String bookUid;
    private String customerCpf;

    public LoanListDTO(Loan loan) {
        this.uid = loan.getUid();
        this.bookUid = loan.getBookUid();
        this.customerCpf = loan.getCustomerCpf();
    }
}
