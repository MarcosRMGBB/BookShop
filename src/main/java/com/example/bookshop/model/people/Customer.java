package com.example.bookshop.model.people;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String uid;
    private String name;
    private int age;
    private String cpf;

    public Customer() {
        this.uid = UUID.randomUUID().toString();
    }
}
