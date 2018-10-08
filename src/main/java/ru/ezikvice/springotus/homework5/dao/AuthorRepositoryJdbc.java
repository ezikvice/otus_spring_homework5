package ru.ezikvice.springotus.homework5.dao;

import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Set;

@Repository
public class AuthorRepositoryJdbc implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int count() {
        Query query = em.createQuery("SELECT COUNT(a.id) FROM author a");
        return (int) query.getSingleResult();
    }

    @Override
    public void insert(Author author) {
        em.persist(author);
    }

    @Override
    public Author findById(int id) {
        return em.find(Author.class, id);
    }

    @Override
    public Set<Author> findByName(String name) {
        Query query = em.createQuery("SELECT * FROM Author a WHERE a.name = :name");
        return (Set<Author>) query.getResultList();
    }

}
