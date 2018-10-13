package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Genre;

public interface GenreRepository {
    void set(Genre genre);

    Genre findById(int id);

    int count();
}
