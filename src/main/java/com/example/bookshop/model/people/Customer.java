package com.example.bookshop.model.people;

import com.example.bookshop.dto.CustomerDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="customer")
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String uid;
    private String name;
    private int age;
    private String cpf;

    public Customer(CustomerDTO customerDTO) {
        this.uid = UUID.randomUUID().toString();
        this.name = customerDTO.getName();
        this.age = customerDTO.getAge();
        this.cpf = customerDTO.getCpf();
    }
}
