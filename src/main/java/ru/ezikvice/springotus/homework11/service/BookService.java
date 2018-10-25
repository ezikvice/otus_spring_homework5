package ru.ezikvice.springotus.homework11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.domain.Book;
import ru.ezikvice.springotus.homework11.domain.Genre;

public interface BookService {

    Mono<Long> count();

    void add(Book book);

    Mono<Book> findById(String bookId);

    Flux<Book> findAll();

    Mono<Book> save(Book book);

    Mono<Void> delete(Book book);

    void addAuthor(Book book, Author author);

    void addGenre(Book book, Genre genre);

    void addComment(String bookId, String comment);
}
