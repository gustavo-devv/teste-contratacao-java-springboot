package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.NewBookDTO;
import com.example.demo.enums.BookStatus;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository repo;

    @GetMapping("/books")
    public ModelAndView findall() {
        List<Book> books = repo.findAll();

        ModelAndView mv = new ModelAndView("Books/index");
        mv.addObject("books", books);
        return mv;
    }

    @GetMapping("/books/new")
    public ModelAndView newBook() {
        ModelAndView mv = new ModelAndView("Books/newBook");
        mv.addObject("status", BookStatus.values());
        return mv;
    }

    @PostMapping("/books")
    public String create(NewBookDTO bookDTO) {
        Book book = bookDTO.toBook();
        repo.save(book);
        System.out.println(book);
        return "redirect:/books";
    }
}
