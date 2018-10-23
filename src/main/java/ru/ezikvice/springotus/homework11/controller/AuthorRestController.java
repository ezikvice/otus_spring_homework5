package ru.ezikvice.springotus.homework11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
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
    public Mono<Author> editAuthor(@PathVariable("id") String id,
                                   @RequestParam("name") String name) {
        return authorService.findById(id).flatMap(a -> {
            a.setName(name);
            return authorService.save(a);
        });
    }

    @PostMapping(path = "/authors/add", produces = "application/json")
    public @ResponseBody
    Mono<Author> addAuthor(@RequestParam("name") String name) {
        Author author = new Author(name);
        author.setName(name);
        return authorService.save(author);
    }
}
