package ru.ezikvice.springotus.homework5.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.service.AuthorService;

import java.util.List;

@ShellComponent
public class AuthorCommands {

    private final AuthorService authorService;

    public AuthorCommands(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ShellMethod(value = "Adding new author", key = {"add-author", "aa"})
    public void addAuthor(
            @ShellOption int id,
            @ShellOption String name) {
        authorService.add(new Author(id, name));
    }

    @ShellMethod(value = "Check number of authors", key = {"count-authors", "ac"})
    public int countAuthors() {
        return authorService.count();
    }

    @ShellMethod(value = "Find author by id", key = {"find-author-by-id", "afi"})
    public Author findById(int id) {
        return authorService.findById(id);
    }

    @ShellMethod(value = "Find author by name", key = {"findById-author-by-name", "afn"})
    public List<Author> findByName(String name) {
        return authorService.findByName(name);
    }
}
