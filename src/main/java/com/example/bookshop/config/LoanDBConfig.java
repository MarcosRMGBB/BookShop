package com.example.bookshop.config;

import com.example.bookshop.model.operations.Loan;
import com.example.bookshop.model.people.Customer;
import com.example.bookshop.model.product.Book;
import com.example.bookshop.model.product.Category;
import com.example.bookshop.repository.BookRepository;
import com.example.bookshop.repository.CustomerRepository;
import com.example.bookshop.repository.LoanRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Configuration
@AllArgsConstructor
public class LoanDBConfig {
    private LoanRepository loanRepository;
    private CustomerRepository customerRepository;
    private BookRepository bookRepository;
    @PostConstruct
    public void loanDB() {
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

        Loan loan = new Loan();
        loan.setUid(UUID.randomUUID().toString());
        loan.setBookUid(book.getUid());
        loan.setCustomerCpf(customer.getCpf());
        loanRepository.saveAndFlush(loan);
    }
}
