package ru.ezikvice.springotus.homework11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Author;

import java.util.List;
import java.util.Set;

public interface AuthorService {

    Mono<Long> count();

    Mono<Author> save(Author author);

    void delete(Author author);

    Mono<Author> findById(String id);

    Flux<Author> findAll();

    Flux<Set<Author>> findByName(String name);

}
