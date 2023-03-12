package com.example.bookshop.model.operation;

import com.example.bookshop.dto.operation.PurchaseDTO;
import com.example.bookshop.dto.operation.PurchaseUpdateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "purchase")
@NoArgsConstructor
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String uid;
    private String bookUid;
    private String customerCpf;
    private LocalDate date;
    private boolean status;

    public Purchase(PurchaseDTO purchaseDTO) {
        this.uid = purchaseDTO.getUid();
        this.bookUid = purchaseDTO.getBookUid();
        this.customerCpf = purchaseDTO.getCustomerCpf();
        this.date = purchaseDTO.getDate();
        this.status = true;
    }
    public void updateData(PurchaseUpdateDTO purchaseUpdateDTO) {
        if(purchaseUpdateDTO.getCustomerCpf() != null) {
            this.customerCpf = purchaseUpdateDTO.getCustomerCpf();
        }
        if(purchaseUpdateDTO.getBookUid() != null) {
            this.bookUid = purchaseUpdateDTO.getBookUid();
        }
    }
}
