package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.GenreDao;
import ru.ezikvice.springotus.homework5.domain.Genre;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao dao;

    public GenreServiceImpl(GenreDao dao) {
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
