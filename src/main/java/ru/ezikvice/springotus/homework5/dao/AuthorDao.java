package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

public interface AuthorDao {

    void insert(Author author);

    Author findById(int id);

    Author findByName(String name);

    List<Author> findByGenre(Genre genre);

    List<Author> findByBook(Book book);
}
