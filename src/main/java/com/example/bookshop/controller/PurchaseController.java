package com.example.bookshop.controller;

import com.example.bookshop.dto.PurchaseDTO;
import com.example.bookshop.model.operations.Purchase;
import com.example.bookshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @PostMapping("/new")
    public ResponseEntity create(@RequestBody @Valid PurchaseDTO purchaseDTO) {
        Purchase purchase =  new Purchase(purchaseDTO);
        purchaseRepository.save(purchase);
        return ResponseEntity
                .ok()
                .body(purchaseDTO);
    }
}
