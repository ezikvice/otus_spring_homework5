package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.BookGenre;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

public interface BookGenreDao {

    void add(Book book, Genre genre);

    void add(int bookId, int genreId);

    BookGenre getById(int id);

    List<Genre> getByBook(Book book);
}
