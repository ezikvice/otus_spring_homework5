package ru.ezikvice.springotus.homework13.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import ru.ezikvice.springotus.homework13.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, Long> {

    Genre save(Genre genre);

    Genre findById(String id);

    long count();
}
