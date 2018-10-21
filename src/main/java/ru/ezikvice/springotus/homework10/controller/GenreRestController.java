package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ezikvice.springotus.homework10.domain.Genre;
import ru.ezikvice.springotus.homework10.service.GenreService;

@RestController
public class GenreRestController {

    private final GenreService genreService;

    @Autowired
    public GenreRestController(GenreService genreService) {
        this.genreService = genreService;
    }

    @PostMapping(path = "/genres/{id}/edit", produces = "application/json")
    public Genre editGenre(@PathVariable("id") String id,
                           @RequestParam("name") String name,
                           @RequestParam("description") String description,
                           Model model) {
        Genre genre = genreService.findById(id);
        genre.setName(name);
        genre.setDescription(description);
        genreService.save(genre);
        model.addAttribute("genre", genre);
        return genre;
    }

    @PostMapping(path = "/genres/add", produces = "application/json")
    public @ResponseBody
    Genre addGenre(@RequestParam("name") String name,
                   @RequestParam("description") String description,
                   Model model) {
        Genre genre = new Genre(name, description);
        genre.setName(name);
        Genre savedGenre = genreService.save(genre);
        model.addAttribute("genre", savedGenre);
        return savedGenre;
    }

}
