package ru.ezikvice.springotus.homework5.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;
import ru.ezikvice.springotus.homework5.service.BookService;

import java.util.List;

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

    @ShellMethod(value = "Getting book by id", key = {"get-book", "bg"})
    public Book getBook(@ShellOption int bookId) {
        return bookService.findById(bookId);
    }

//    @ShellMethod(value = "Get list of authors", key = {"book-get-authors", "bga"})
//    public int getAuthors() {
//        return bookService.count();
//    }

    @ShellMethod(value = "Get list of genres", key = {"book-get-genres", "bgg"})
    public List<Genre> getGenres(@ShellOption int bookId) {
        return bookService.getGenres(bookId);
    }


    @ShellMethod(value = "Add the genre to the book", key = {"book-add-genre", "bag"})
    public void addGenreToBook(int bookId, int genreId) {
        bookService.addGenre(bookId, genreId);
    }

    @ShellMethod(value = "Add the author to the book", key = {"book-add-author", "baa"})
    public void addAuthorToBook(int bookId, int authorId) {
        bookService.addAuthor(bookId, authorId);
    }

    //    @ShellMethod(value = "Find author by id", key = {"find-author-by-id", "afi"})
//    public Author findById(int id) {
//        return authorService.findById(id);
//    }
//
//    @ShellMethod(value = "Find author by name", key = {"findById-author-by-name", "afn"})
//    public Author findByName(String name) {
//        return authorService.findByName(name);
//    }
}
