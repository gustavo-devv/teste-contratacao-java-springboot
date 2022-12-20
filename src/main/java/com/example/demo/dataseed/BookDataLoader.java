package com.example.demo.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.controller.LibraryController;
import com.example.demo.enums.BookStatus;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Component
public class BookDataLoader implements CommandLineRunner {

    @Autowired
    private BookRepository repo;

    @Autowired
    private LibraryController libController;

    @Override
    public void run(String... args) throws Exception {
        loadBookData();
    }

    private void loadBookData() {
        Book book = new Book();
        if (repo.count() == 0) {
            book.setAuthor("Dan Brown");
            book.setName("O Codigo da vinci");
            book.setStatus(BookStatus.AVAILABLE);
            book.setLibrary(libController.findById(1));
            repo.save(book);
        }

    }

}