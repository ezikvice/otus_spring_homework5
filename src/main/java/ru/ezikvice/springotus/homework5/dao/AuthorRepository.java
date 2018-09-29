package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;

import java.util.List;

public interface AuthorRepository {

    int count();

    void insert(Author author);

    Author findById(int id);

    List<Author> findByName(String name);
}
