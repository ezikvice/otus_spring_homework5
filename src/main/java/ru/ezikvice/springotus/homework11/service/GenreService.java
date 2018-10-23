package ru.ezikvice.springotus.homework11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Genre;

import java.util.List;

public interface GenreService {

    Mono<Long> count();

    void add(Genre genre);

    Mono<Genre> findById(String genreId);

    Mono<Genre> save(Genre genre);

    void delete(Genre genre);

    Flux<Genre> findAll();
}
