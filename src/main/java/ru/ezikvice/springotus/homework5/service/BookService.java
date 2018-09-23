package ru.ezikvice.springotus.homework5.service;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

public interface BookService {

    int count();

    void add(Book book);

    Book findById(int bookId);

    void addAuthor(Book book, Author author);

    void addAuthor(int bookId, int authorId);

    void addGenre(Book book, Genre genre);

    void addGenre(int bookId, int genreId);

    List<Genre> getGenres(Book book);

    List<Genre> getGenres(int bookId);
}
