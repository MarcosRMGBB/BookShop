package com.example.bookshop.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoanUpdateDTO {
    private String bookUid;
    private String customerCpf;
}
