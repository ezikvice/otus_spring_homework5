package ru.ezikvice.springotus.homework9.service;

import ru.ezikvice.springotus.homework9.domain.Author;
import ru.ezikvice.springotus.homework9.domain.Book;
import ru.ezikvice.springotus.homework9.domain.Comment;
import ru.ezikvice.springotus.homework9.domain.Genre;

import java.util.List;
import java.util.Set;

public interface BookService {

    long count();

    void add(Book book);

    Book findById(String bookId);

    void addAuthor(Book book, Author author);

    void addAuthor(String bookId, String authorId);

    void addGenre(Book book, Genre genre);

    void addGenre(String bookId, String genreId);

    void addComment(String bookId, String comment);

    List<Comment> getComments(String bookId);

    Set<Genre> getGenres(Book book);

    Set<Genre> getGenres(String bookId);

    Set<Author> getAuthors(String bookId);
}
