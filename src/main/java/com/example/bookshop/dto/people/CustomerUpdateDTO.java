package com.example.bookshop.dto.people;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
@Getter
public class CustomerUpdateDTO {
    private long id;
    private String name;
    private Integer age;
    private String cpf;
}
