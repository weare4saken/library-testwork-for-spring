package com.skypro.library.service;

import com.skypro.library.dao.BookDAO;
import com.skypro.library.entity.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.skypro.library.exception.BookException;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private BookDAO bookDAO;

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Override
    @Transactional
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    @Transactional
    public Book getBookByIsbn(String isbn) {
        Book book = bookDAO.getBookByIsbn(isbn);

        if (book == null) {
            throw new BookException("Book with isbn= " + isbn + "doesn't exist");
        }

        return book;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    @Override
    @Transactional
    public void deleteBook(String isbn) {

        Book book = bookDAO.getBookByIsbn(isbn);

        if (book == null) {
            throw new BookException("Employee with isbn= " + isbn + "doesn't exist");
        }

        bookDAO.deleteBook(isbn);
    }

}

