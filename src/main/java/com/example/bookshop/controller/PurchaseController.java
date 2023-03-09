package com.example.bookshop.controller;

import com.example.bookshop.dto.PurchaseDTO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    private static List<PurchaseDTO> purchaseList = Collections.synchronizedList(
            new ArrayList<>() {{
                add(new PurchaseDTO(UUID.randomUUID().toString(), "Dom Casmuro",
                        "001.001.001-02"));
            }}
    );

    @GetMapping("/list")
    public synchronized ResponseEntity<Collection<PurchaseDTO>> list(
            @RequestParam(defaultValue = "0") int page) {
        List<PurchaseDTO> list = page == 0 ? purchaseList.stream()
                .skip(page)
                .limit(1)
                .collect(Collectors.toList())
        return ResponseEntity
                .ok()
                .header("List-Size", Integer.toString(purchaseList.size()))
                .body(list);
    }
}
