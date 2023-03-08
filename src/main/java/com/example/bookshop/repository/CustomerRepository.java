package com.example.bookshop.repository;

import com.example.bookshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value="SELECT c FROM Customer c")
    List<Customer> findAllHQL();
}
