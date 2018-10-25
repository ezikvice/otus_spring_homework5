package ru.ezikvice.springotus.homework11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.dao.GenreRepository;
import ru.ezikvice.springotus.homework11.domain.Genre;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository rep;

    @Autowired
    public GenreServiceImpl(GenreRepository rep) {
        this.rep = rep;
    }

    @Override
    public Mono<Long> count() {
        return rep.count();
    }

    @Override
    public void add(Genre genre) {
        rep.save(genre);
    }

    @Override
    public Mono<Genre> findById(String genreId) {
        return rep.findById(genreId);
    }


    @Override
    public Flux<Genre> findAll() {
        return rep.findAll();
    }

    @Override
    public Mono<Genre> save(Genre genre) {
        return rep.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        rep.delete(genre);
    }


}
