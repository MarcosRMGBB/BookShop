package com.example.bookshop.model.operations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "loan")
@Getter
@Setter
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String uid;
    String bookUid;
    String customerCpf;

    public Loan() {
        this.uid = UUID.randomUUID().toString();
    }
}
