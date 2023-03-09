package com.example.bookshop.model.operations;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="purchase")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;
    String uid;
    String bookTitle;
    String customerCpf;
}
