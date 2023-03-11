package com.example.bookshop.model.operation;

import com.example.bookshop.dto.operation.PurchaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

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

    public Purchase(PurchaseDTO purchaseDTO) {
        this.uid = purchaseDTO.getUid();
        this.bookUid = purchaseDTO.getBookUid();
        this.customerCpf = purchaseDTO.getCustomerCpf();
        this.date = purchaseDTO.getDate();
    }
}
