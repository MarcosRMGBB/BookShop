package com.example.bookshop.model.operations;

import com.example.bookshop.dto.LoanDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loan")
@Getter
@Setter
@NoArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String uid;
    private String bookUid;
    private String customerCpf;

    public Loan(LoanDTO loanDTO) {
        this.uid = UUID.randomUUID().toString();
        this.bookUid = loanDTO.getBookUid();
        this.customerCpf = loanDTO.getCustomerCpf();
    }
}
