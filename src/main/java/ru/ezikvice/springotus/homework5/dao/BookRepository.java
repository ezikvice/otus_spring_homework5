package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

public interface BookRepository {

    int count();

    void save(Book book);

    void saveAuthor(Book book, Author author);

    void saveGenre(Book book, Genre genre);

    Book getById(int id);

}
