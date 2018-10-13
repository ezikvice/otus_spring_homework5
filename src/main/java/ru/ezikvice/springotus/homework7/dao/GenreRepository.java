package ru.ezikvice.springotus.homework7.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ezikvice.springotus.homework7.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre save(Genre genre);

    Genre findById(int id);

    long count();
}
