package com.skypro.library.dao;

import com.skypro.library.entity.Book;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    private SessionFactory sessionFactory;

    public BookDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getBooks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Book").list();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, isbn);
    }

    @Override
    public void addBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.save(book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.update(book);
    }

    @Override
    public void deleteBook(String isbn) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("delete from Book where isbn=:isbn");
        query.setParameter("isbn", isbn);
        query.executeUpdate();
    }

}
