package com.skypro.library.entity;

public class Book {

    private String bookName;
    private String bookAuthor;
    private int releaseYear;
    private String isbn;

    public Book() {
    }

    public Book(String bookName, String bookAuthor, int releaseYear, String isbn) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.releaseYear = releaseYear;
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
