package ru.ezikvice.springotus.homework5.service;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

public interface BookService {

    int count();

    void add(Book book);

    Book findById(int bookId);

    void addAuthor(Author author);

    void addGenre(Genre genre);
}
