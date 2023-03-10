package com.example.bookshop.dto;

import com.example.bookshop.model.operations.Purchase;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@JsonSerialize
@Getter
public class PurchaseListDTO {
    private String uid;
    private String bookUid;
    private String customerCpf;

    public PurchaseListDTO(Purchase purchase) {
        this.uid = purchase.getUid();
        this.bookUid = purchase.getBookUid();
        this.customerCpf = purchase.getCustomerCpf();
    }
}
