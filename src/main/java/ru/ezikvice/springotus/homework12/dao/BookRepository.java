package ru.ezikvice.springotus.homework12.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ezikvice.springotus.homework12.domain.Book;

public interface BookRepository extends MongoRepository<Book, Long> {

    Book save(Book book);

    Book findById(String id);
}
