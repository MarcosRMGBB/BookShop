package com.example.bookshop.dto.operation;

import com.example.bookshop.model.operation.Purchase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

import java.time.LocalDate;

@JsonSerialize
@Getter
public class PurchaseListDTO {
    private String uid;
    private String bookUid;
    private String customerCpf;
    private LocalDate date;

    public PurchaseListDTO(Purchase purchase) {
        this.uid = purchase.getUid();
        this.bookUid = purchase.getBookUid();
        this.customerCpf = purchase.getCustomerCpf();
        this.date = purchase.getDate();
    }
}
