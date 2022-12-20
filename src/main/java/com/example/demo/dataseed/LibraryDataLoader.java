package com.example.demo.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;

@Component
public class LibraryDataLoader implements CommandLineRunner {

    @Autowired
    private LibraryRepository repo;

    @Override
    public void run(String... args) throws Exception {
        loadLibraryData();
    }

    private void loadLibraryData() {
        Library library = new Library();
        if (repo.count() == 0) {
            library.setName("Coletanea Gustavo");
            library.setAddress("Rua 01 - Brasilia-DF");
            repo.save(library);
        }
    }
}