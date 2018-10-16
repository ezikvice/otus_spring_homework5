package ru.ezikvice.springotus.homework10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework10.dao.GenreRepository;
import ru.ezikvice.springotus.homework10.domain.Genre;

import java.util.List;

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
    public Genre findById(String genreId) {
        return rep.findById(genreId);
    }


    @Override
    public List<Genre> findAll() {
        return rep.findAll();
    }

    @Override
    public Genre save(Genre genre) {
        return rep.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        rep.delete(genre);
    }


}
