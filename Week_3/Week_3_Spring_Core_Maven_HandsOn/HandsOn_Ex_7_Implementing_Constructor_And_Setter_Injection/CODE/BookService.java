package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String info;

    // Constructor Injection
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter Injection
    public void setInfo(String info) {
        this.info = info;
    }

    public void display() {
        System.out.println("Constructor Injected Book: " + bookRepository.getBook());
        System.out.println("Setter Injected Info: " + info);
    }
}
