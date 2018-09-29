package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Book;

public interface BookRepository {

    int count();

    void insert(Book book);

    Book getById(int id);

}
