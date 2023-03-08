package com.example.bookshop.repository;

import com.example.bookshop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value="SELECT b FROM Book b")
    List<Book> findAllHQL();
}
