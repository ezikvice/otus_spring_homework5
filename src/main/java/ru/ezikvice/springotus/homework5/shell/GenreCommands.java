package ru.ezikvice.springotus.homework5.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.homework5.domain.Genre;
import ru.ezikvice.springotus.homework5.service.GenreService;

@ShellComponent
public class GenreCommands {
    private final GenreService genreService;

    public GenreCommands(GenreService genreService) {
        this.genreService = genreService;
    }

    @ShellMethod(value = "Adding new genre", key = {"add-genre", "ga"})
    public void addGenre(
            @ShellOption String name,
            @ShellOption String description) {
        genreService.add(new Genre(name, description));
    }

    @ShellMethod(value = "Check number of genres", key = {"count-genres", "gc"})
    public int countGenres() {
        return genreService.count();
    }

    @ShellMethod(value = "Find Genre by id", key = {"find-genre-by-id", "gfi"})
    public Genre findById(int id) {
        return genreService.find(id);
    }
}
