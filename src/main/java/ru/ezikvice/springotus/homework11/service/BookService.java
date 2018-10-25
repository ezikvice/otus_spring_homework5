package ru.ezikvice.springotus.homework11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.domain.Book;
import ru.ezikvice.springotus.homework11.domain.Comment;
import ru.ezikvice.springotus.homework11.domain.Genre;

import java.util.List;
import java.util.Set;

public interface BookService {

    Mono<Long> count();

    void add(Book book);

    Mono<Book> findById(String bookId);

    Flux<Book> findAll();

    Mono<Book> save(Book book);

    void delete(Book book);

    void addAuthor(Book book, Author author);

//    void addAuthor(String bookId, String authorId);

//    void addGenre(Book book, Genre genre);
//
//    void addGenre(String bookId, String genreId);
//
//    void addComment(String bookId, String comment);
//
//    Flux<Comment> getComments(String bookId);
//
//    Flux<Genre> getGenres(Book book);
//
//    Set<Genre> getGenres(String bookId);
//
//    Set<Author> getAuthors(String bookId);
}
