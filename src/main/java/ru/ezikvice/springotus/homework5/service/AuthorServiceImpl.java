package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.AuthorDao;
import ru.ezikvice.springotus.homework5.domain.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    public AuthorServiceImpl(AuthorDao dao) {
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
    public Author findByName(String name) {
        return dao.findByName(name);
    }
}
