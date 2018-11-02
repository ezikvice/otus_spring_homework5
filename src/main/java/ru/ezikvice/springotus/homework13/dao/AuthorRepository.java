package ru.ezikvice.springotus.homework13.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends MongoRepository<Author, String> {

    @PreAuthorize("hasPermission(#author, 'WRITE') or hasRole('AUTHOR_EDITOR')")
    Author save(@Param("author") Author author);

    Set<Author> findByName(String name);

    @PreFilter("filterObject == authentication.name")
    List<Author> findAll();
}
