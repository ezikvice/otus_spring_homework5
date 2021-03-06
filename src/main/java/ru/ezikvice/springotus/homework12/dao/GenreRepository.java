package ru.ezikvice.springotus.homework12.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.ezikvice.springotus.homework12.domain.Genre;

public interface GenreRepository extends MongoRepository<Genre, Long> {
    Genre save(Genre genre);

    Genre findById(String id);

    long count();
}
