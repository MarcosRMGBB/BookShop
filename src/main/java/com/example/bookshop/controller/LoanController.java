package com.example.bookshop.controller;

import com.example.bookshop.dto.LoanDTO;
import com.example.bookshop.model.operations.Loan;
import com.example.bookshop.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;
    @PostMapping("/new")
    public ResponseEntity create(@RequestBody LoanDTO loanDTO) {
        Loan loan = new Loan(loanDTO);
        loanRepository.save(loan);
        return ResponseEntity
                .ok()
                .body(loanDTO);
    }
}
