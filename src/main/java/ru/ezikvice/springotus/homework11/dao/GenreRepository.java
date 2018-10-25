package ru.ezikvice.springotus.homework11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Genre;

public interface GenreRepository extends ReactiveMongoRepository<Genre, Long> {
    Mono<Genre> save(Genre genre);

    Mono<Genre> findById(String id);

    Mono<Long> count();
}
