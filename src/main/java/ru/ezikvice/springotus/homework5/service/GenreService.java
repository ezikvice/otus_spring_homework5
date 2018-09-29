package ru.ezikvice.springotus.homework5.service;

import ru.ezikvice.springotus.homework5.domain.Genre;

public interface GenreService {

    int count();

    void add(Genre genre);

    Genre find(int genreId);
}
