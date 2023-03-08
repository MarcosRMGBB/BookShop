package com.example.bookshop.service;

import com.example.bookshop.model.Customer;
import com.example.bookshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> all() {
        return customerRepository.findAllHQL();
    }
}
