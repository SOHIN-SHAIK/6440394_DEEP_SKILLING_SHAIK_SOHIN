package com.library;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(BookRepository repo) {
        return args -> {
            repo.save(new Book(1L, "Joshua Bloch", "Effective Java"));
            repo.save(new Book(2L, "Robert C. Martin", "Clean Code"));
        };
    }
}
