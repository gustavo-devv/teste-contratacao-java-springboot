package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;

@Controller
public class LibraryController {

    private final LibraryRepository repo;

    public LibraryController(LibraryRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/id")
    public Library findById(Integer id) {
        return repo.findById(id).get();
    }
}
