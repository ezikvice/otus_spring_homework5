package ru.ezikvice.springotus.homework12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ezikvice.springotus.homework12.domain.Genre;
import ru.ezikvice.springotus.homework12.service.GenreService;

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

    @GetMapping("/genres/{id}/delete")
    public String deleteGenre(@PathVariable("id") String id, Model model) {
        Genre genre = genreService.findById(id);
        genreService.delete(genre);
        return "redirect:/genres/get";
    }
}
