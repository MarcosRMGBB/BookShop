package com.example.bookshop.model.operations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String uid;
    String bookUid;
    String customerCpf;

    public Purchase() {
        this.uid = UUID.randomUUID().toString();
    }
}
