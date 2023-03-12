package com.example.bookshop.controller;

import com.example.bookshop.dto.operation.LoanDTO;
import com.example.bookshop.dto.operation.LoanListDTO;
import com.example.bookshop.dto.operation.LoanUpdateDTO;
import com.example.bookshop.model.operation.Loan;
import com.example.bookshop.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;
    @Transactional
    @PostMapping("/new")
    public ResponseEntity create(@RequestBody @Valid LoanDTO loanDTO) {
        Loan loan = new Loan(loanDTO);
        loanRepository.save(loan);
        return ResponseEntity
                .ok()
                .body(loanDTO);
    }
    @GetMapping("/list")
    public Page<LoanListDTO> list(@PageableDefault(size = 5, sort = {"startDate"}) Pageable page) {
        return loanRepository.findAllByStatusTrue(page).map(LoanListDTO::new);
    }
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody LoanUpdateDTO loanUpdateDTO, @PathVariable long id) {
        Loan loan = loanRepository.getReferenceById(id);
        loan.updateData(loanUpdateDTO);
        LoanDTO loanDTO = new LoanDTO(loan);
        return ResponseEntity
                .ok()
                .body(loanDTO);
    }
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Loan loan = loanRepository.getReferenceById(id);
        loan.setStatus(false);
        LoanDTO loanDTO = new LoanDTO(loan);
        return ResponseEntity
                .ok()
                .body(loanDTO);
    }
}
