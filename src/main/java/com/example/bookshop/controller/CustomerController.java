package com.example.bookshop.controller;

import com.example.bookshop.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    private static List<CustomerDTO> customerList = Collections.synchronizedList(
            new ArrayList() {{
                add(new CustomerDTO(UUID.randomUUID().toString(), "Marcos", 23, "001.001.001-02"));
                add(new CustomerDTO(UUID.randomUUID().toString(), "Lucas", 35, "001.001.001-03"));
                add(new CustomerDTO(UUID.randomUUID().toString(), "Luis", 15, "001.001.001-04"));
            }}
    );

    @GetMapping("/list")
    public synchronized ResponseEntity<Collection<CustomerDTO>> list(
            @RequestParam(defaultValue = "0") int page
    ) {
        List<CustomerDTO> list = page == 0 ? customerList : customerList.stream().skip(page).limit(1).collect(Collectors.toList());
        return ResponseEntity
                .ok()
                .header("List-Size", Integer.toString(customerList.size()))
                .body(list);
    }

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody CustomerDTO customer) {
        ResponseEntity.noContent().build();
        customerList.add(customer);
        return ResponseEntity.ok().build();
    }
}
