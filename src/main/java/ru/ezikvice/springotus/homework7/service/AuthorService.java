package ru.ezikvice.springotus.homework7.service;

import ru.ezikvice.springotus.homework7.domain.Author;

import java.util.Set;

public interface AuthorService {

    long count();

    void add(Author author);

    Author findById(int id);

    Set<Author> findByName(String name);

}
