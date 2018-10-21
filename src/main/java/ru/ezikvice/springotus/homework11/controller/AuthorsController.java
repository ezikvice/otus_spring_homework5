package ru.ezikvice.springotus.homework11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.service.AuthorService;

import java.util.List;

@Controller
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors/get")
    public String listPage(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/authors/{id}/delete")
    public String deleteAuthor(@PathVariable("id") String id, Model model) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "redirect:/authors/get";
    }
}
