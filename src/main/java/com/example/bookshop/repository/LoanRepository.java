package com.example.bookshop.repository;

import com.example.bookshop.model.operation.Loan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query(value = "SELECT l FROM Loan l")
    List<Loan> findAllHQL();

    @Query(value = "SELECT l FROM Loan l WHERE l.status = true")
    Page<Loan> findAllByStatusTrue(Pageable page);
}
