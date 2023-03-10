package com.example.bookshop.controller;

import com.example.bookshop.dto.CustomerDTO;
import com.example.bookshop.model.people.Customer;
import com.example.bookshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        customerRepository.save(customer);
        return ResponseEntity
                .ok()
                .body(customerDTO);
    }
}
