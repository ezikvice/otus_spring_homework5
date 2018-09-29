package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Genre;

public interface GenreRepository {
    void set(Genre genre);

    Genre getById(int id);

    int count();
}
