package com.example.bookshop.controller;

import com.example.bookshop.dto.people.CustomerDTO;
import com.example.bookshop.dto.people.CustomerListDTO;
import com.example.bookshop.dto.people.CustomerUpdateDTO;
import com.example.bookshop.model.people.Customer;
import com.example.bookshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/customer")
@RestController
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
    public Page<CustomerListDTO> list(@PageableDefault(size = 5, sort = {"name"}) Pageable page) {
        return customerRepository.findAllByStatusTrue(page).map(CustomerListDTO::new);
    }
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody CustomerUpdateDTO customerUpdateDTO, @PathVariable long id) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.updateData(customerUpdateDTO);
        CustomerDTO customerDTO = new CustomerDTO(customer);
        return ResponseEntity
                .ok()
                .body(customerDTO);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        Customer customer = customerRepository.getReferenceById(id);
        customer.setStatus(false);
        CustomerDTO customerDTO = new CustomerDTO(customer);
        return ResponseEntity
                .ok()
                .body(customerDTO);
    }
}
