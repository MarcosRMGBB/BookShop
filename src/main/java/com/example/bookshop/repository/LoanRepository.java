package com.example.bookshop.repository;

import com.example.bookshop.model.operation.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query(value = "SELECT l FROM Loan l")
    List<Loan> findAllHQL();
}
