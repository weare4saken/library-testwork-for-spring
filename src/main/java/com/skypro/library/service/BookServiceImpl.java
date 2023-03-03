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

        validateBook(book);

        bookDAO.addBook(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {

        Book updatedBook = this.bookDAO.getBookByIsbn(book.getIsbn());

        updatedBook.setBookName(book.getBookName());
        updatedBook.setBookAuthor(book.getBookName());
        updatedBook.setReleaseYear(book.getReleaseYear());

        validateBook(updatedBook);

        bookDAO.updateBook(updatedBook);
    }

    @Override
    @Transactional
    public void deleteBook(String isbn) {

        Book book = bookDAO.getBookByIsbn(isbn);

        if (book == null) {
            throw new BookException("Book with isbn= " + isbn + "doesn't exist");
        }

        bookDAO.deleteBook(isbn);
    }

    private boolean validateBook(Book book) { //где его реализовывать?

        if (book.getBookName() == null || book.getBookAuthor() == null
                || book.getIsbn() == null || book.getReleaseYear() < 0) {
            throw new BookException("Not all fields of the book are filled in");
        }

        String currentIsbn = book.getIsbn();
        String cleandedIsbn = currentIsbn.replaceAll("[\\-\\s]", "");

        if (cleandedIsbn.length() != 13 && !cleandedIsbn.matches("[0-9]+")) {
            throw new BookException("Invalid ISBN");
        }

        int sum = 0;
        for (int i = 0; i < cleandedIsbn.length(); i++) {
            int digit = Character.getNumericValue(cleandedIsbn.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }

        int checkDigit = 10 - (sum % 10);

//        if(checkDigit == 10) {
//            checkDigit = 0;
//        }

        return checkDigit == Character.getNumericValue(cleandedIsbn.charAt(cleandedIsbn.length()-1));
    }

}

