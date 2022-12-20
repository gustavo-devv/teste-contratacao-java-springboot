package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Library;
import com.example.demo.repository.LibraryRepository;

@Controller
@RestController("/library")
public class LibraryController {

    @Autowired
    private LibraryRepository repo;

    @GetMapping("/{id}")
    public Library findById(Integer id) {
        return repo.findById(id).get();
    }

    @GetMapping("/all")
    public List<Library> findAll() {
        return repo.findAll();
    }
}
