package ru.ezikvice.springotus.homework5.dao;

import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Comment;
import ru.ezikvice.springotus.homework5.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class BookRepositoryJdbc implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int count() {
        Query query = em.createQuery("SELECT COUNT(b.id) FROM book b");
        return (int) query.getSingleResult();
    }

    @Override
    public void save(Book book) {
        em.persist(book);
    }

    @Override
    public void saveAuthor(Book book, Author author) {
        book.addAuthor(author);
        em.persist(book);
    }

    @Override
    public void saveGenre(Book book, Genre genre) {
        book.addGenre(genre);
        em.persist(book);
    }

    @Override
    public void saveComment(Book book, Comment comment) {
//        em.persist(comment);
        book.addComment(comment);
        em.persist(book);
    }

    @Override
    public Book getById(int id) {
        return em.find(Book.class, id);
    }
}
