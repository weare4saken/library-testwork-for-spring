package com.skypro.library.controller;

import com.skypro.library.entity.Book;
import com.skypro.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("skypro")
public class RestControllerNew {

    //добавить куда то GET /web - Показываем страницу со списком книг любому пользователю

    private BookService bookService;

    public RestControllerNew(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/book")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/api/book/{isbn}") //может быть сделать как в методе delete?
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    @PostMapping("/api/book")
    public Book addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return book;
    }

    @PutMapping("/api/book")
    public Book updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
        return book;
    }

    @DeleteMapping("/api/book?isbn=<isbn>")
    public String deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return "Book with isbn= " + isbn + " was deleted";
    }

}

