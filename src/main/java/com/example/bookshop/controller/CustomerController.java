package com.example.bookshop.controller;

import com.example.bookshop.dto.CustomerDTO;
import com.example.bookshop.dto.CustomerListDTO;
import com.example.bookshop.model.people.Customer;
import com.example.bookshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/customer")
@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = new Customer(customerDTO);
        customerRepository.save(customer);
        return ResponseEntity
                .ok()
                .body(customerDTO);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CustomerListDTO>> list() {
        List<CustomerListDTO> customerListDTO = customerRepository.findAllHQL().stream()
                .map(CustomerListDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity
                .ok()
                .body(customerListDTO);
    }
}
