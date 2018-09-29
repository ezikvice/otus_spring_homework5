package ru.ezikvice.springotus.homework5.service;

import ru.ezikvice.springotus.homework5.domain.Author;

import java.util.List;

public interface AuthorService {

    int count();

    void add(Author author);

    Author findById(int id);

    List<Author> findByName(String name);

}
