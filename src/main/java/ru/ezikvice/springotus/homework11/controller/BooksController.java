package ru.ezikvice.springotus.homework11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.domain.Book;
import ru.ezikvice.springotus.homework11.domain.Comment;
import ru.ezikvice.springotus.homework11.domain.Genre;
import ru.ezikvice.springotus.homework11.service.AuthorService;
import ru.ezikvice.springotus.homework11.service.BookService;
import ru.ezikvice.springotus.homework11.service.GenreService;

import java.util.List;

@Controller
public class BooksController {

    private final BookService bookService;
    private final AuthorService authorService;
    private final GenreService genreService;


    @Autowired
    public BooksController(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.genreService = genreService;
    }

    @GetMapping("/books/get")
    public String listPage(Model model) {
        List<Book> books = bookService.findAll().collectList().block();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}/edit")
    public String editBook(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id).block();
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping("/books/{bookId}/add-author")
    public String addAuthor(@PathVariable("bookId") String bookId,
                            @RequestParam("authorId") String authorId,
                            Model model) {
        Book book = bookService.findById(bookId).block();
        Author author = authorService.findById(authorId).block();
        book.addAuthor(author);
        Book savedBook = bookService.save(book).block();
        model.addAttribute("book", savedBook);
        return "redirect:/books/" + savedBook.getId() + "/edit";
    }

    @PostMapping("/books/{bookId}/add-genre")
    public String addGenre(@PathVariable("bookId") String bookId,
                           @RequestParam("genreId") String genreId,
                           Model model) {
        Book book = bookService.findById(bookId).block();
        Genre genre = genreService.findById(genreId).block();
        book.addGenre(genre);
        Book savedBook = bookService.save(book).block();
        model.addAttribute("book", savedBook);
        return "redirect:/books/" + savedBook.getId() + "/edit";
    }

    @PostMapping("/books/{bookId}/add-comment")
    public String addComment(@PathVariable("bookId") String bookId,
                             @RequestParam("comment") String comment,
                             Model model) {
        Book book = bookService.findById(bookId).block();
        book.addComment(new Comment(comment));
        Book savedBook = bookService.save(book).block();
        model.addAttribute("book", savedBook);
        return "redirect:/books/" + savedBook.getId() + "/edit";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id).block();
        bookService.delete(book);
        return "redirect:/books/get";
    }
}
