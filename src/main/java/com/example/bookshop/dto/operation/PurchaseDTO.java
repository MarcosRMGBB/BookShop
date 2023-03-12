package com.example.bookshop.dto.operation;

import com.example.bookshop.model.operation.Purchase;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
    private boolean status;

    public PurchaseDTO() {
        this.uid = UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.status = true;
    }
    public PurchaseDTO(Purchase purchase) {
        this.uid = purchase.getUid();
        this.bookUid = purchase.getBookUid();
        this.customerCpf = purchase.getCustomerCpf();
        this.date = purchase.getDate();
    }
}

