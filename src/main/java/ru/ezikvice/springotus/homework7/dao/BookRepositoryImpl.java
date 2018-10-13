package ru.ezikvice.springotus.homework7.dao;

import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework7.domain.Author;
import ru.ezikvice.springotus.homework7.domain.Book;
import ru.ezikvice.springotus.homework7.domain.Comment;
import ru.ezikvice.springotus.homework7.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

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
        book.addComment(comment);
        em.persist(book);
    }
}
