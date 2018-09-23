package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;

public interface AuthorDao {

    int count();

    void insert(Author author);

    Author findById(int id);

    Author findByName(String name);
}
