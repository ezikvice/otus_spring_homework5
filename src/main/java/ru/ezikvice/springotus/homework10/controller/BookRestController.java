package ru.ezikvice.springotus.homework10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ezikvice.springotus.homework10.domain.Book;
import ru.ezikvice.springotus.homework10.service.BookService;

@RestController
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/books/{id}/edit", produces = "application/json")
    public Book editBook(@PathVariable("id") String id,
                         @RequestParam("name") String name,
                         @RequestParam("description") String description,
                         Model model) {
        Book book = bookService.findById(id);
        book.setName(name);
        book.setDescription(description);
        bookService.save(book);
        model.addAttribute("book", book);
        return book;
    }

    @PostMapping(path = "/books/add", produces = "application/json")
    public @ResponseBody
    Book addBook(@RequestParam("name") String name,
                 @RequestParam("description") String description,
                 Model model) {
        Book book = new Book(name, description);
        book.setName(name);
        Book savedBook = bookService.save(book);
        model.addAttribute("book", savedBook);
        return savedBook;
    }

}
