package ru.ezikvice.springotus.homework7.service;

import ru.ezikvice.springotus.homework7.domain.Author;
import ru.ezikvice.springotus.homework7.domain.Book;
import ru.ezikvice.springotus.homework7.domain.Comment;
import ru.ezikvice.springotus.homework7.domain.Genre;

import java.util.List;
import java.util.Set;

public interface BookService {

    long count();

    void add(Book book);

    Book findById(int bookId);

    void addAuthor(Book book, Author author);

    void addAuthor(int bookId, int authorId);

    void addGenre(Book book, Genre genre);

    void addGenre(int bookId, int genreId);

    void addComment(int bookId, String comment);

    List<Comment> getComments(int bookId);

    Set<Genre> getGenres(Book book);

    Set<Genre> getGenres(int bookId);

    Set<Author> getAuthors(int bookId);
}
