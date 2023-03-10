package com.example.bookshop.repository;

import com.example.bookshop.model.operations.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    @Query(value = "SELECT p FROM Purchase p")
    List<Purchase> findAllHQL();
}