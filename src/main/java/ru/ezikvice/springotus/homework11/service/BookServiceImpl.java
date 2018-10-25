package ru.ezikvice.springotus.homework11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.ezikvice.springotus.homework11.dao.AuthorRepository;
import ru.ezikvice.springotus.homework11.dao.BookRepository;
import ru.ezikvice.springotus.homework11.dao.GenreRepository;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.domain.Book;
import ru.ezikvice.springotus.homework11.domain.Comment;
import ru.ezikvice.springotus.homework11.domain.Genre;

import java.util.List;
import java.util.Set;

@Service
//@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRep;
    private final GenreRepository genreRep;
    private final AuthorRepository authorRep;

    @Autowired
    public BookServiceImpl(BookRepository bookRep, GenreRepository genreRep, AuthorRepository authorRep) {
        this.bookRep = bookRep;
        this.genreRep = genreRep;
        this.authorRep = authorRep;
    }

    @Override
    public Mono<Long> count() {
        return bookRep.count();
    }

    @Override
    public void add(Book book) {
        bookRep.save(book);
    }

    @Override
    public Mono<Book> findById(String bookId) {
        return bookRep.findById(bookId);
    }

    @Override
    public Flux<Book> findAll() {
        return bookRep.findAll();
    }

    @Override
    public Mono<Book> save(Book book) {
        return bookRep.save(book);
    }

    @Override
    public Mono<Void> delete(Book book) {
        return bookRep.delete(book);
    }

    @Override
    public void addAuthor(Book book, Author author) {
        book.addAuthor(author);
        bookRep.save(book).block();
    }

    @Override
    public void addGenre(Book book, Genre genre) {
        book.addGenre(genre);
        bookRep.save(book).block();
    }


    @Override
    public void addComment(String bookId, String text) {
        Book book = bookRep.findById(bookId).block();
        book.addComment(new Comment(text));
        bookRep.save(book).block();
    }
}
