package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;

import java.util.Set;

public interface AuthorRepository {

    int count();

    void insert(Author author);

    Author findById(int id);

    Set<Author> findByName(String name);
}
