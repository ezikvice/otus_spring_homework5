package ru.ezikvice.springotus.homework8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework8.dao.AuthorRepository;
import ru.ezikvice.springotus.homework8.domain.Author;

import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public long count() {
        return authorRepository.count();
    }

    @Override
    public void add(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author findById(String id) {
        return authorRepository.findById(id);
    }

    @Override
    public Set<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }
}
