package ru.ezikvice.springotus.homework13.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends MongoRepository<Author, String> {

    @PreAuthorize("hasPermission(#author, admin)")
    Author save(@Param("author") Author author);

    Set<Author> findByName(String name);

    List<Author> findAll();
}
