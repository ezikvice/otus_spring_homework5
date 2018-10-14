package ru.ezikvice.springotus.homework9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework9.dao.GenreRepository;
import ru.ezikvice.springotus.homework9.domain.Genre;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository rep;

    @Autowired
    public GenreServiceImpl(GenreRepository rep) {
        this.rep = rep;
    }

    @Override
    public long count() {
        return rep.count();
    }

    @Override
    public void add(Genre genre) {
        rep.save(genre);
    }

    @Override
    public Genre find(String genreId) {
        return rep.findById(genreId);
    }
}
