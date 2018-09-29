package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.GenreRepository;
import ru.ezikvice.springotus.homework5.domain.Genre;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository dao;

    public GenreServiceImpl(GenreRepository dao) {
        this.dao = dao;
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void add(Genre genre) {
        dao.set(genre);
    }

    @Override
    public Genre find(int genreId) {
        return dao.getById(genreId);
    }
}
