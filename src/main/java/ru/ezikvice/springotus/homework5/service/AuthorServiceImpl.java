package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.AuthorRepository;
import ru.ezikvice.springotus.homework5.domain.Author;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository dao;

    public AuthorServiceImpl(AuthorRepository dao) {
        this.dao = dao;
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void add(Author author) {
        dao.insert(author);
    }

    @Override
    public Author findById(int id) {
        return dao.findById(id);
    }

    @Override
    public Set<Author> findByName(String name) {
        return dao.findByName(name);
    }
}
