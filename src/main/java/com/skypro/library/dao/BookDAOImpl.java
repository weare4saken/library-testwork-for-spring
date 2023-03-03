package com.skypro.library.dao;

import com.skypro.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


    @Override
    public List<Book> getBooks() {
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return jdbcTemplate.query("SELECT * FROM books WHERE isbn = ?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    @Override
    public void addBook(Book book) {
        jdbcTemplate.update("INSERT INTO books VALUES (?, ?, ?, ?)",
                book.getBookName(), book.getBookAuthor(), book.getReleaseYear(), book.getIsbn());
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update("INSERT INTO books (book_name, book_author, release_year) VALUES (?, ?, ?)",
                book.getBookName(), book.getBookAuthor(), book.getReleaseYear(), book.getIsbn());
    }

    @Override
    public void deleteBook(String isbn) {

        jdbcTemplate.query("DELETE FROM books WHERE isbn = ?",
                new Object[]{isbn},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

}
