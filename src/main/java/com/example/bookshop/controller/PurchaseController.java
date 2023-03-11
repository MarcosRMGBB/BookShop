package com.example.bookshop.controller;

import com.example.bookshop.dto.operation.PurchaseDTO;
import com.example.bookshop.dto.operation.PurchaseListDTO;
import com.example.bookshop.model.operation.Purchase;
import com.example.bookshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
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

    @GetMapping("/list")
    public Page<PurchaseListDTO> list(Pageable page) {
        return purchaseRepository.findAll(page).map(PurchaseListDTO::new);

    }
}
