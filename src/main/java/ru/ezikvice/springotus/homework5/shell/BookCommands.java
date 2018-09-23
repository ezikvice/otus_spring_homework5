package ru.ezikvice.springotus.homework5.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.service.AuthorService;
import ru.ezikvice.springotus.homework5.service.BookService;

@ShellComponent
public class BookCommands {

    private final BookService bookService;


    public BookCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Adding new book", key = {"add-book", "ba"})
    public void addAuthor(
            @ShellOption int id,
            @ShellOption String name,
            @ShellOption String description) {
        bookService.add(new Book(id, name, description));
    }

//    @ShellMethod(value = "Get list of authors", key = {"book-get-authors", "bga"})
//    public int getAuthors() {
//        return bookService.count();
//    }

    @ShellMethod(value = "Get list of genres", key = {"book-get-genres", "bgg"})
    public int getGenres() {
        return bookService.;
    }

    @ShellMethod(value = "Find author by id", key = {"find-author-by-id", "afi"})
    public Author findById(int id) {
        return authorService.findById(id);
    }

    @ShellMethod(value = "Find author by name", key = {"findById-author-by-name", "afn"})
    public Author findByName(String name) {
        return authorService.findByName(name);
    }
}
