package ru.ezikvice.springotus.homework8.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ezikvice.springotus.homework8.domain.Author;

import java.util.Set;

public interface AuthorRepository extends MongoRepository<Author, Long> {

    Author save(Author author);

    Author findById(String id);

    Set<Author> findByName(String name);
}
