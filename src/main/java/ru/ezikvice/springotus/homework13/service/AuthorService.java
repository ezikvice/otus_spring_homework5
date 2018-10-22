package ru.ezikvice.springotus.homework13.service;

import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.List;
import java.util.Set;

public interface AuthorService {

    long count();

    Author save(Author author);

    void delete(Author author);

    Author findById(String id);

    List<Author> findAll();

    Set<Author> findByName(String name);

}
