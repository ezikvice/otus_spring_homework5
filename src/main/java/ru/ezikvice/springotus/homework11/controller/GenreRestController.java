package ru.ezikvice.springotus.homework11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Genre;
import ru.ezikvice.springotus.homework11.service.GenreService;

@RestController
public class GenreRestController {

    private final GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping(path = "/genres/{id}/edit", produces = "application/json")
    public Mono<Genre> editGenre(@PathVariable("id") String id,
                                 @RequestParam("name") String name,
                                 @RequestParam("description") String description) {
        return genreService.findById(id).flatMap(genre -> {
            genre.setName(name);
            genre.setDescription(description);
            return genreService.save(genre);
        });
    }

    @PostMapping(path = "/genres/add", produces = "application/json")
    public @ResponseBody
    Mono<Genre> addGenre(@RequestParam("name") String name,
                         @RequestParam("description") String description) {
        Genre genre = new Genre(name, description);
        genre.setName(name);
        return genreService.save(genre);
    }

}
