package ru.ezikvice.springotus.homework5.service;

import ru.ezikvice.springotus.homework5.domain.Author;

public interface AuthorService {

    int count();

    void add(Author author);

    Author findById(int id);

    Author findByName(String name);

}
