package com.example.bookshop.dto.people;

import com.example.bookshop.model.people.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String uid;
    @NotBlank
    private String name;
    @NotNull
    private int age;
    @NotBlank
    private String cpf;

    public CustomerDTO() {
        this.uid = UUID.randomUUID().toString();
    }

    public CustomerDTO(Customer customer) {
        this.uid = customer.getUid();
        this.age = customer.getAge();
        this.name = customer.getName();
        this.cpf = customer.getCpf();
    }
}
