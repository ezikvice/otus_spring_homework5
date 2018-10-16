package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ezikvice.springotus.homework10.domain.Author;
import ru.ezikvice.springotus.homework10.domain.Book;
import ru.ezikvice.springotus.homework10.domain.Comment;
import ru.ezikvice.springotus.homework10.domain.Genre;
import ru.ezikvice.springotus.homework10.service.AuthorService;
import ru.ezikvice.springotus.homework10.service.BookService;
import ru.ezikvice.springotus.homework10.service.GenreService;

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
        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/edit")
    public String editBook(@RequestParam("id") String id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping("/books/edit")
    public String editBook(@RequestParam("id") String id,
                           @RequestParam("namr") String name,
                           @RequestParam("description") String description,
                           Model model) {
        Book book = bookService.findById(id);
        book.setName(name);
        book.setDescription(description);
        bookService.save(book);
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping("/books/add-author")
    public String addAuthor(@RequestParam("bookId") String id,
                            @RequestParam("authorId") String authorId,
                            Model model) {
        Book book = bookService.findById(id);
        Author author = authorService.findById(authorId);
        book.addAuthor(author);
        bookService.save(book);
        model.addAttribute("book", book);
        return "redirect:/books/edit?id=" + book.getId();
    }

    @PostMapping("/books/add-genre")
    public String addGenre(@RequestParam("bookId") String id,
                           @RequestParam("genreId") String genreId,
                           Model model) {
        Book book = bookService.findById(id);
        Genre genre = genreService.findById(genreId);
        book.addGenre(genre);
        bookService.save(book);
        model.addAttribute("book", book);
        return "redirect:/books/edit?id=" + book.getId();
    }

    @PostMapping("/books/add-comment")
    public String addComment(@RequestParam("bookId") String id,
                             @RequestParam("comment") String comment,
                             Model model) {
        Book book = bookService.findById(id);
        book.addComment(new Comment(comment));
        bookService.save(book);
        model.addAttribute("book", book);
        return "redirect:/books/edit?id=" + book.getId();
    }

    @GetMapping("/books/delete")
    public String deleteBook(@RequestParam("id") String id, Model model) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "redirect:/books/get";
    }

    @GetMapping("/books/add")
    public String viewAddBook(Model model) {
        return "book-add";
    }

    @PostMapping("/books/add")
    public String addBook(@RequestParam("namr") String name,
                          @RequestParam("description") String description,
                          Model model) {
        Book book = new Book(name, description);
        book.setName(name);
        Book savedBook = bookService.save(book);
        model.addAttribute("book", savedBook);
        return "redirect:/books/edit?id=" + savedBook.getId();
    }

}
