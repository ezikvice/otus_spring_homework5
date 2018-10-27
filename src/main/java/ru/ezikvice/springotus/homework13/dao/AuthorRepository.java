package ru.ezikvice.springotus.homework13.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.Set;

public interface AuthorRepository extends MongoRepository<Author, Long> {

    @PreAuthorize("hasRole('ROLE_AUTHOR_EDITOR')")
    Author save(Author author);

    Author findById(String id);

    Set<Author> findByName(String name);
}
