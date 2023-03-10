package com.example.bookshop.config;

import com.example.bookshop.model.people.Customer;
import com.example.bookshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
@AllArgsConstructor
public class CustomerDBConfig {
    private CustomerRepository customerRepository;

    @PostConstruct
    public void customerDB() {
        Customer customer1 = new Customer();
        customer1.setUid(UUID.randomUUID().toString());
        customer1.setAge(25);
        customer1.setName("Leitor");
        customer1.setCpf("001.002.003-04");
        customerRepository.saveAndFlush(customer1);
    }
}
