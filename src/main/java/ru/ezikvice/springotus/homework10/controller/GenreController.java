package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ezikvice.springotus.homework10.domain.Genre;
import ru.ezikvice.springotus.homework10.service.GenreService;

import java.util.List;

@Controller
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/genres/get")
    public String listPage(Model model) {
        List<Genre> genres = genreService.findAll();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping("/genres/{id}/edit")
    public String viewGenre(@PathVariable("id") String id, Model model) {
        Genre genre = genreService.findById(id);
        model.addAttribute("genre", genre);
        return "genre-edit";
    }

    @PostMapping("/genres/{id}/edit")
    public String editGenre(@PathVariable("id") String id,
                            @RequestParam("name") String name,
                            @RequestParam("description") String description,
                            Model model) {
        Genre genre = genreService.findById(id);
        genre.setName(name);
        genre.setDescription(description);
        genreService.save(genre);
        model.addAttribute("genre", genre);
        return "genre-edit";
    }

    @GetMapping("/genres/{id}/delete")
    public String deleteGenre(@PathVariable("id") String id, Model model) {
        Genre genre = genreService.findById(id);
        genreService.delete(genre);
        return "redirect:/genres/get";
    }

    @GetMapping("/genres/add")
    public String viewAddGenre(Model model) {
        return "genre-add";
    }

    @PostMapping("/genres/add")
    public String addGenre(@RequestParam("name") String name,
                           @RequestParam("description") String description,
                           Model model) {
        Genre genre = new Genre(name, description);
        genre.setName(name);
        Genre savedGenre = genreService.save(genre);
        model.addAttribute("genre", savedGenre);
        return "redirect:/genres/" + savedGenre.getId() + "/edit?id=";
    }

}
