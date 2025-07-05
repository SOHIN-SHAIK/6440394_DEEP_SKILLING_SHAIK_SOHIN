package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private String info;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void display() {
        List<Book> books = bookRepository.findAll();
        System.out.println("Books from DB:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
        System.out.println("Info: " + info);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
