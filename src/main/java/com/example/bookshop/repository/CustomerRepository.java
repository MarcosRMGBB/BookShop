package com.example.bookshop.repository;

import com.example.bookshop.model.people.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value="SELECT c FROM Customer c")
    List<Customer> findAllHQL();

    @Query(value="SELECT c FROM Customer c WHERE c.status = true")
    Page<Customer> findAllByStatusTrue(Pageable page);
}
