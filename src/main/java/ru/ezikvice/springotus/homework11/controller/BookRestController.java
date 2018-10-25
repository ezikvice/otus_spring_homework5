package ru.ezikvice.springotus.homework11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.domain.Book;
import ru.ezikvice.springotus.homework11.service.BookService;

@RestController
public class BookRestController {

    private final BookService bookService;

    @Autowired
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/books/{id}/edit", produces = "application/json")
    public Mono<Book> editBook(@PathVariable("id") String id,
                               @RequestParam("name") String name,
                               @RequestParam("description") String description) {
        return bookService.findById(id).flatMap(book -> {
            book.setName(name);
            book.setDescription(description);
            return bookService.save(book);
        });
    }

    @PostMapping(path = "/books/add", produces = "application/json")
    public @ResponseBody
    Mono<Book> addBook(@RequestParam("name") String name,
                       @RequestParam("description") String description) {
        Book book = new Book(name, description);
        book.setName(name);
        return bookService.save(book);
    }

}
