package ru.ezikvice.springotus.homework5.service;

import ru.ezikvice.springotus.homework5.domain.Author;

import java.util.Set;

public interface AuthorService {

    int count();

    void add(Author author);

    Author findById(int id);

    Set<Author> findByName(String name);

}
