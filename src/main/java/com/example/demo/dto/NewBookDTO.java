package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.controller.LibraryController;
import com.example.demo.enums.BookStatus;
import com.example.demo.model.Book;
import com.example.demo.model.Library;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NewBookDTO {

    @NotBlank
    @NotNull
    private String author;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private BookStatus status;
    private Integer library_id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Integer getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(Integer library_id) {
        this.library_id = library_id;
    }

    public void fromBook(Book book) {
        this.name = book.getName();
        this.author = book.getAuthor();
        this.status = book.getStatus();
        this.library_id = book.getLibrary().getId();
        // this.library_id = book.getLibrary();
    }

    public Book toBook() {
        Book book = new Book();
        book.setAuthor(this.author);
        book.setName(this.name);
        book.setStatus(this.status);
        return book;
    }

    @Override
    public String toString() {
        return "NewBookDTO{" +
                "author='" + author + " \'" +
                ", name='" + name +
                "', status='" + status +
                "', library='" + library_id + "}";
    }
}
