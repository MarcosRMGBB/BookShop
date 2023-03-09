package com.example.bookshop.model.operations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bookLoan")
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String uid;
    String bookUid;
    String customerCpf;
}
