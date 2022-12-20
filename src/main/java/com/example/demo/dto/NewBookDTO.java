package com.example.demo.dto;

import com.example.demo.enums.BookStatus;
import com.example.demo.model.Book;

public class NewBookDTO {

    private String author;
    private String name;
    private BookStatus status;

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
                ", status='" + status + "}";
    }
}
