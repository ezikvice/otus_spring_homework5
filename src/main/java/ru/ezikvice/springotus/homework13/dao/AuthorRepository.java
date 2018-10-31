package ru.ezikvice.springotus.homework13.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ezikvice.springotus.homework13.domain.Author;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends CrudRepository<Author, Long> {

    //    @PreAuthorize("hasPermission(#author, 'WRITE')")
    Author save(@Param("author") Author author);

//    Author findById(Long id);

    Set<Author> findByName(String name);

    //    @PostFilter("hasPermission(filterObject, 'READ')")
    List<Author> findAll();
}
