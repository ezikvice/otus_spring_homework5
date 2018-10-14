package ru.ezikvice.springotus.homework9.service;

import ru.ezikvice.springotus.homework9.domain.Genre;

public interface GenreService {

    long count();

    void add(Genre genre);

    Genre find(String genreId);
}
