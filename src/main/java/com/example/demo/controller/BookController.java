package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.NewBookDTO;
import com.example.demo.enums.BookStatus;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository repo;

    @Autowired
    private LibraryController libraryController;

    @GetMapping("/")
    public ModelAndView findAll() {
        List<Book> books = repo.findAll();

        ModelAndView mv = new ModelAndView("Books/index");
        mv.addObject("books", books);
        return mv;
    }

    @GetMapping("/new")
    public ModelAndView newBook() {
        ModelAndView mv = new ModelAndView("Books/newBook");
        mv.addObject("status", BookStatus.values());
        mv.addObject("library", libraryController.findAll());
        return mv;
    }

    @PostMapping("/")
    public String create(@Valid NewBookDTO bookDTO, BindingResult bindingResult) {
        System.out.println(bookDTO);
        if (bindingResult.hasErrors()) {
            System.out.println("********** Tem erros ***************");
            return "redirect:/books";
        } else {
            Book book = bookDTO.toBook();
            book.setLibrary(libraryController.findById(bookDTO.getLibrary_id()));
            repo.save(book);
            return "redirect:/books/" + book.getId();
        }

    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Integer id) {
        System.out.println("******* ID: " + id);
        Optional<Book> optional = repo.findById(id);

        if (optional.isPresent()) {
            Book book = optional.get();
            ModelAndView mv = new ModelAndView("books/show");
            mv.addObject("book", book);
            return mv;

        } else {
            return new ModelAndView("redirect:/books/");
        }

    }

    @GetMapping("/{id}/edit")
    public ModelAndView editBook(@PathVariable Integer id, NewBookDTO bookDTO) {
        Optional<Book> optional = repo.findById(id);

        if (optional.isPresent()) {
            Book book = optional.get();
            bookDTO.fromBook(book);

            ModelAndView mv = new ModelAndView("books/edit");
            mv.addObject("bookId", book.getId());
            mv.addObject("status", BookStatus.values());
            mv.addObject("library", libraryController.findAll());

            repo.save(book);
            return mv;

        } else {
            return new ModelAndView("redirect:/books/");
        }
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        try {
            repo.deleteById(id);
            return "redirect:/books/";

        } catch (EmptyResultDataAccessException e) {
            System.out.println(e);
            return "redirect:/books/";
        }
    }
}
