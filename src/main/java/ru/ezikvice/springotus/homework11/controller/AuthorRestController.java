package ru.ezikvice.springotus.homework11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.service.AuthorService;

@RestController
public class AuthorRestController {

    private final AuthorService authorService;

    @Autowired
    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "/authors/{id}/edit", produces = "application/json")
    public Author editAuthor(@PathVariable("id") String id,
                             @RequestParam("name") String name,
                             Model model) {
        Author author = authorService.findById(id);
        author.setName(name);
        authorService.save(author);
        model.addAttribute("author", author);
        return author;
    }

    @PostMapping(path = "/authors/add", produces = "application/json")
    public @ResponseBody
    Author addAuthor(@RequestParam("name") String name, Model model) {
        Author author = new Author(name);
        author.setName(name);
        Author savedAuthor = authorService.save(author);
        model.addAttribute("author", savedAuthor);
        return savedAuthor;
    }

}
