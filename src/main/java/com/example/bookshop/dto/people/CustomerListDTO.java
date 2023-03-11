package com.example.bookshop.dto.people;

import com.example.bookshop.model.people.Customer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;

@Getter
@JsonSerialize
public class CustomerListDTO {
    private String uid;
    private String name;
    private int age;
    private String cpf;

    public CustomerListDTO(Customer customer) {
        this.uid = customer.getUid();
        this.name = customer.getName();
        this.age = customer.getAge();
        this.cpf = customer.getCpf();
    }
}
