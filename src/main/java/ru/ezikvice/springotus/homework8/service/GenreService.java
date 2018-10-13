package ru.ezikvice.springotus.homework8.service;

import ru.ezikvice.springotus.homework8.domain.Genre;

public interface GenreService {

    long count();

    void add(Genre genre);

    Genre find(String genreId);
}
