package ru.ezikvice.springotus.homework5.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.homework5.domain.Genre;
import ru.ezikvice.springotus.homework5.service.GenreService;

@ShellComponent
public class Commands {
    private final GenreService genreService;

    public Commands(GenreService genreService) {
        this.genreService = genreService;
    }

    @ShellMethod(value = "Adding new genre", key = {"genreadd", "ga"})
    public void addGenre(
            @ShellOption int id,
            @ShellOption String name,
            @ShellOption String description) {
        genreService.add(new Genre(id, name, description));
    }

    @ShellMethod(value = "Check number of genres", key = {"genrecount", "gc"})
    public int genreCount() {
        return genreService.count();
    }

}
