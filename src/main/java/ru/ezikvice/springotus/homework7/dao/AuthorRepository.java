package ru.ezikvice.springotus.homework7.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ezikvice.springotus.homework7.domain.Author;

import java.util.Set;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author save(Author author);

    Author findById(int id);

    Set<Author> findByName(String name);
}
