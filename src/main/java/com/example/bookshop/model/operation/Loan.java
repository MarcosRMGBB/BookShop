package com.example.bookshop.model.operation;

import com.example.bookshop.dto.operation.LoanDTO;
import com.example.bookshop.dto.operation.LoanUpdateDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

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
    private boolean status;

    public Loan(LoanDTO loanDTO) {
        this.uid = loanDTO.getUid();
        this.bookUid = loanDTO.getBookUid();
        this.customerCpf = loanDTO.getCustomerCpf();
        this.startDate = loanDTO.getStartDate();
        this.endDate = loanDTO.getEndDate();
        this.status = true;
    }

    public void updateData(LoanUpdateDTO loanUpdateDTO) {
        if(loanUpdateDTO.getBookUid() != null) {
            this.bookUid = loanUpdateDTO.getBookUid();
        }
        if(loanUpdateDTO.getCustomerCpf() != null) {
            this.customerCpf = loanUpdateDTO.getCustomerCpf();
        }
    }
}
