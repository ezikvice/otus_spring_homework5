package ru.ezikvice.springotus.homework7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework7.dao.GenreRepository;
import ru.ezikvice.springotus.homework7.domain.Genre;

import javax.transaction.Transactional;

@Service
@Transactional
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository rep;

    @Override
    public long count() {
        return rep.count();
    }

    @Override
    public void add(Genre genre) {
        rep.save(genre);
    }

    @Override
    public Genre find(int genreId) {
        return rep.findById(genreId);
    }
}
