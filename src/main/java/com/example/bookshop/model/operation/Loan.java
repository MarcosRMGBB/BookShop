package com.example.bookshop.model.operation;

import com.example.bookshop.dto.operation.LoanDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate startDate;
    private LocalDate endDate;

    public Loan(LoanDTO loanDTO) {
        this.uid = loanDTO.getUid();
        this.bookUid = loanDTO.getBookUid();
        this.customerCpf = loanDTO.getCustomerCpf();
        this.startDate = loanDTO.getStartDate();
        this.endDate = loanDTO.getEndDate();
    }
}
