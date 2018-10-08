package ru.ezikvice.springotus.homework5.dao;

import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class GenreRepositoryJdbc implements GenreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void set(Genre genre) {
        em.persist(genre);
    }

    @Override
    public Genre findById(int id) {
        return em.find(Genre.class, id);
    }

    @Override
    public int count() {
        Query query = em.createQuery("SELECT COUNT(g.id) FROM genre g");
        return (int) query.getSingleResult();
    }

}
