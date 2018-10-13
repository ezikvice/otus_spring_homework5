package ru.ezikvice.springotus.homework8.service;

import ru.ezikvice.springotus.homework8.domain.Author;

import java.util.Set;

public interface AuthorService {

    long count();

    void add(Author author);

    Author findById(String id);

    Set<Author> findByName(String name);

}
