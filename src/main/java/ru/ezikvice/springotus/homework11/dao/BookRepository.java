package ru.ezikvice.springotus.homework11.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, Long> {

    Mono<Book> save(Book book);

    Mono<Book> findById(String id);
}
