package ru.ezikvice.springotus.homework10.service;

import ru.ezikvice.springotus.homework10.domain.Genre;

import java.util.List;

public interface GenreService {

    long count();

    void add(Genre genre);

    Genre findById(String genreId);

    Genre save(Genre genre);

    void delete(Genre genre);

    List<Genre> findAll();
}
