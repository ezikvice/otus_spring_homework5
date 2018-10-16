package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/authors/edit")
    public String viewAuthor(@RequestParam("id") String id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "author-edit";
    }

    @PostMapping("/authors/edit")
    public String editAuthor(@RequestParam("id") String id,
                             @RequestParam("namr") String name,
                             Model model) {
        Author author = authorService.findById(id);
        author.setName(name);
        authorService.save(author);
        model.addAttribute("author", author);
        return "author-edit";
    }

    @GetMapping("/authors/delete")
    public String deleteAuthor(@RequestParam("id") String id, Model model) {
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
    public String addAuthor(@RequestParam("namr") String name,
                            Model model) {
        Author author = new Author(name);
        author.setName(name);
        Author savedAuthor = authorService.save(author);
        model.addAttribute("author", savedAuthor);
        return "redirect:/authors/edit?id=" + savedAuthor.getId();
    }


}
