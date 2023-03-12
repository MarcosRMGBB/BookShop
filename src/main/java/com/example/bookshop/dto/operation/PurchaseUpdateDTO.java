package com.example.bookshop.dto.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class PurchaseUpdateDTO {
    private String bookUid;
    private String customerCpf;
}
