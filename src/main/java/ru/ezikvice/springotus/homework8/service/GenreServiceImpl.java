package ru.ezikvice.springotus.homework8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework8.dao.GenreRepository;
import ru.ezikvice.springotus.homework8.domain.Genre;

import javax.transaction.Transactional;

@Service
@Transactional
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
