package com.example.bookshop.controller;

import com.example.bookshop.dto.operation.PurchaseDTO;
import com.example.bookshop.dto.operation.PurchaseListDTO;
import com.example.bookshop.dto.operation.PurchaseUpdateDTO;
import com.example.bookshop.model.operation.Purchase;
import com.example.bookshop.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Transactional
    @PostMapping("/new")
    public ResponseEntity create(@RequestBody @Valid PurchaseDTO purchaseDTO) {
        Purchase purchase =  new Purchase(purchaseDTO);
        purchaseRepository.save(purchase);
        return ResponseEntity
                .ok()
                .body(purchaseDTO);
    }
    @GetMapping("/list")
    public Page<PurchaseListDTO> list(@PageableDefault(sort = {"date"}) Pageable page) {
        return purchaseRepository.findAllByStatusTrue(page).map(PurchaseListDTO::new);
    }
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable long id, @RequestBody PurchaseUpdateDTO purchaseUpdateDTO) {
        Purchase purchase = purchaseRepository.getReferenceById(id);
        purchase.updateData(purchaseUpdateDTO);
        PurchaseDTO purchaseDTO = new PurchaseDTO(purchase);
        return ResponseEntity
                .ok()
                .body(purchaseDTO);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Purchase purchase = purchaseRepository.getReferenceById(id);
        purchase.setStatus(false);
        PurchaseDTO purchaseDTO = new PurchaseDTO(purchase);
        return ResponseEntity
                .ok()
                .body(purchaseDTO);
    }
}
