package ru.ezikvice.springotus.homework5.dao;

import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Book;

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
    public void insert(Book book) {
        em.persist(book);
    }

    @Override
    public Book getById(int id) {
        return em.find(Book.class, id);
    }
}
