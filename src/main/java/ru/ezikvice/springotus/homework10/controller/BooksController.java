package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/books/{id}/edit")
    public String editBook(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book-edit";
    }

    @PostMapping("/books/{bookId}/add-author")
    public String addAuthor(@PathVariable("bookId") String bookId,
                            @RequestParam("authorId") String authorId,
                            Model model) {
        Book book = bookService.findById(bookId);
        Author author = authorService.findById(authorId);
        book.addAuthor(author);
        bookService.save(book);
        model.addAttribute("book", book);
        return "redirect:/books/" + book.getId() + "/edit";
    }

    @PostMapping("/books/{bookId}/add-genre")
    public String addGenre(@PathVariable("bookId") String bookId,
                           @RequestParam("genreId") String genreId,
                           Model model) {
        Book book = bookService.findById(bookId);
        Genre genre = genreService.findById(genreId);
        book.addGenre(genre);
        bookService.save(book);
        model.addAttribute("book", book);
        return "redirect:/books/" + book.getId() + "/edit";
    }

    @PostMapping("/books/{bookId}/add-comment")
    public String addComment(@PathVariable("bookId") String bookId,
                             @RequestParam("comment") String comment,
                             Model model) {
        Book book = bookService.findById(bookId);
        book.addComment(new Comment(comment));
        bookService.save(book);
        model.addAttribute("book", book);
        return "redirect:/books/" + book.getId() + "/edit";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "redirect:/books/get";
    }

//    @GetMapping("/books/add")
//    public String viewAddBook(Model model) {
//        return "book-add";
//    }
//
//    @PostMapping("/books/add")
//    public String addBook(@RequestParam("name") String name,
//                          @RequestParam("description") String description,
//                          Model model) {
//        Book book = new Book(name, description);
//        book.setName(name);
//        Book savedBook = bookService.save(book);
//        model.addAttribute("book", savedBook);
//        return "redirect:/books/" + savedBook.getId() + "/edit";
//    }

}
