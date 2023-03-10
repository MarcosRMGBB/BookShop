package com.example.bookshop.controller;

import com.example.bookshop.dto.BookDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/book")
public class BookController {
    private static List<BookDTO> bookList = Collections.synchronizedList(
            new ArrayList() {{
                add(new BookDTO(UUID.randomUUID().toString(), "Dom Casmuro", "Machado de Assis",
                        "Literature", 25.0));
                add(new BookDTO(UUID.randomUUID().toString(), "Assim Falou Zaratustra", "Friedrich Nietzsche",
                        "Philosophy", 50.0));
                add(new BookDTO(UUID.randomUUID().toString(), "Tao Te Ching", "Lao Tse", "Philosophy",
                        100.0));
            }}
    );

    @GetMapping("/list")
    public synchronized ResponseEntity<Collection<BookDTO>> list(
            @RequestParam(defaultValue = "0") int page
    ) {
        List<BookDTO> list = page == 0 ? bookList : bookList.stream()
                                                            .skip(page)
                                                            .limit(1)
                                                            .collect(Collectors.toList());
        return ResponseEntity
                .ok()
                .header("List-Size", Integer.toString(bookList.size()))
                .body(list);
    }

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody BookDTO book) {
        ResponseEntity.noContent().build();
        bookList.add(book);
        return ResponseEntity.ok().build();
    }
}
