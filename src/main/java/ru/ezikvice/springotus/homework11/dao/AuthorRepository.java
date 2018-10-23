package ru.ezikvice.springotus.homework11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Author;

import java.util.Set;

public interface AuthorRepository extends ReactiveMongoRepository<Author, Long> {

    Mono<Author> save(Author author);

    Mono<Author> findById(String id);

    Flux<Set<Author>> findByName(String name);
}
