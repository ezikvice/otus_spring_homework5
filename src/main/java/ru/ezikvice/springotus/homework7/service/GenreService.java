package ru.ezikvice.springotus.homework7.service;

import ru.ezikvice.springotus.homework7.domain.Genre;

public interface GenreService {

    long count();

    void add(Genre genre);

    Genre find(int genreId);
}
