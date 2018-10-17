package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ezikvice.springotus.homework10.domain.Author;
import ru.ezikvice.springotus.homework10.service.AuthorService;

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

    @GetMapping("/authors/{id}/edit")
    public String viewAuthor(@PathVariable("id") String id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author-edit";
    }

    @PostMapping("/authors/{id}/edit")
    public String editAuthor(@PathVariable("id") String id,
                             @RequestParam("name") String name,
                             Model model) {
        Author author = authorService.findById(id);
        author.setName(name);
        authorService.save(author);
        model.addAttribute("author", author);
        return "author-edit";
    }

    @GetMapping("/authors/{id}/delete")
    public String deleteAuthor(@PathVariable("id") String id, Model model) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        return "redirect:/authors/get";
    }

    @GetMapping("/authors/add")
    public String viewAddAuthor(Model model) {
        return "author-add";
    }

    @PostMapping("/authors/add")
    public String addAuthor(@RequestParam("name") String name,
                            Model model) {
        Author author = new Author(name);
        author.setName(name);
        Author savedAuthor = authorService.save(author);
        model.addAttribute("author", savedAuthor);
        return "redirect:/authors/" + savedAuthor.getId() + "/edit?id=";
    }


}
