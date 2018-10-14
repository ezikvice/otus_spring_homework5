package ru.ezikvice.springotus.homework9.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.ezikvice.springotus.homework9.domain.Author;
import ru.ezikvice.springotus.homework9.domain.Book;
import ru.ezikvice.springotus.homework9.domain.Comment;
import ru.ezikvice.springotus.homework9.domain.Genre;
import ru.ezikvice.springotus.homework9.service.BookService;

import java.util.List;
import java.util.Set;

@ShellComponent
public class BookCommands {

    private final BookService bookService;


    public BookCommands(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Adding new book", key = {"add-book", "ba"})
    public void addAuthor(
            @ShellOption String name,
            @ShellOption String description) {
        bookService.add(new Book(name, description));
    }

    @ShellMethod(value = "Getting book by id", key = {"get-book", "bg"})
    public Book getBook(@ShellOption String bookId) {
        return bookService.findById(bookId);
    }

    @ShellMethod(value = "Get list of authors", key = {"book-get-authors", "bga"})
    public Set<Author> getAuthors(@ShellOption String bookId) {
        return bookService.getAuthors(bookId);
    }

    @ShellMethod(value = "Get list of genres", key = {"book-get-genres", "bgg"})
    public Set<Genre> getGenres(@ShellOption String bookId) {
        return bookService.getGenres(bookId);
    }

    @ShellMethod(value = "Get list of comments", key = {"book-get-comments", "bgc"})
    public List<Comment> getComments(@ShellOption String bookId) {
        return bookService.getComments(bookId);
    }


    @ShellMethod(value = "Add the genre to the book", key = {"book-add-genre", "bag"})
    public void addGenreToBook(String bookId, String genreId) {
        bookService.addGenre(bookId, genreId);
    }

    @ShellMethod(value = "Add the author to the book", key = {"book-add-author", "baa"})
    public void addAuthorToBook(String bookId, String authorId) {
        bookService.addAuthor(bookId, authorId);
    }

    @ShellMethod(value = "Add the comment to the book", key = {"book-add-comment", "bac"})
    public void addCommentToBook(String bookId, String comment) {
        bookService.addComment(bookId, comment);
    }
}