package com.example.bookshop.config;

import com.example.bookshop.model.operation.Purchase;
import com.example.bookshop.model.people.Customer;
import com.example.bookshop.model.product.Book;
import com.example.bookshop.model.product.Category;
import com.example.bookshop.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.UUID;

@Configuration
@AllArgsConstructor
public class PurchaseDBConfig {
    private PurchaseRepository purchaseRepository;
    @PostConstruct
    private void purchaseDB() {
        Book book = new Book();
        book.setUid(UUID.randomUUID().toString());
        book.setTitle("Dom Casmurro");
        book.setAuthor("Machado de Assis");
        book.setCategory(Category.LITERATURE);
        book.setPrice(45.0);

        Customer customer = new Customer();
        customer.setUid(UUID.randomUUID().toString());
        customer.setAge(25);
        customer.setName("Leitor");
        customer.setCpf("001.002.003-04");

        Purchase purchase = new Purchase();
        purchase.setUid(UUID.randomUUID().toString());
        purchase.setBookUid(book.getUid());
        purchase.setCustomerCpf(customer.getCpf());
        purchase.setDate(LocalDate.now());
        purchase.setStatus(true);
        purchaseRepository.saveAndFlush(purchase);
    }
}
