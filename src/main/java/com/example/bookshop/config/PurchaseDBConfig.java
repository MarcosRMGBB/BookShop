package com.example.bookshop.config;

import com.example.bookshop.model.operations.Purchase;
import com.example.bookshop.model.people.Customer;
import com.example.bookshop.model.product.Book;
import com.example.bookshop.model.product.Category;
import com.example.bookshop.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@AllArgsConstructor
public class PurchaseDBConfig {
    private PurchaseRepository purchaseRepository;
    @PostConstruct
    private void purchaseDB() {
        Book book = new Book();
        book.setTitle("Dom Casmurro");
        book.setAuthor("Machado de Assis");
        book.setCategory(Category.LITERATURE);
        book.setPrice(45.0);

        Customer customer = new Customer();
        customer.setAge(25);
        customer.setName("Leitor");
        customer.setCpf("001.002.003-04");

        Purchase purchase = new Purchase();
        purchase.setBookUid(book.getUid());
        purchase.setCustomerCpf(customer.getCpf());
        purchaseRepository.saveAndFlush(purchase);
    }
}
