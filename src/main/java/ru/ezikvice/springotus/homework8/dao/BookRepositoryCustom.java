package ru.ezikvice.springotus.homework8.dao;

import ru.ezikvice.springotus.homework8.domain.Author;
import ru.ezikvice.springotus.homework8.domain.Book;
import ru.ezikvice.springotus.homework8.domain.Comment;
import ru.ezikvice.springotus.homework8.domain.Genre;

public interface BookRepositoryCustom {

    void saveAuthor(Book book, Author author);

    void saveGenre(Book book, Genre genre);

    void saveComment(Book book, Comment comment);
}
