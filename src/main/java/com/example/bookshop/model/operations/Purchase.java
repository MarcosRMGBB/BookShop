package com.example.bookshop.model.operations;

import com.example.bookshop.dto.PurchaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    public Purchase(PurchaseDTO purchaseDTO) {
        this.uid = UUID.randomUUID().toString();
        this.bookUid = purchaseDTO.getBookUid();
        this.customerCpf = purchaseDTO.getCustomerCpf();
    }
}
