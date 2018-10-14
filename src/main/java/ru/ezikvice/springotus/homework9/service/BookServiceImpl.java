package ru.ezikvice.springotus.homework9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework9.dao.AuthorRepository;
import ru.ezikvice.springotus.homework9.dao.BookRepository;
import ru.ezikvice.springotus.homework9.dao.GenreRepository;
import ru.ezikvice.springotus.homework9.domain.Author;
import ru.ezikvice.springotus.homework9.domain.Book;
import ru.ezikvice.springotus.homework9.domain.Comment;
import ru.ezikvice.springotus.homework9.domain.Genre;

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
    public long count() {
        return bookRep.count();
    }

    @Override
    public void add(Book book) {
        bookRep.save(book);
    }

    @Override
    public Book findById(String bookId) {
        return bookRep.findById(bookId);
    }

    @Override
    public void addAuthor(Book book, Author author) {
        book.addAuthor(author);
        bookRep.save(book);
    }

    @Override
    public void addAuthor(String bookId, String authorId) {
        Book book = bookRep.findById(bookId);
        Author author = authorRep.findById(authorId);
        book.addAuthor(author);
        bookRep.save(book);
    }

    @Override
    public void addGenre(Book book, Genre genre) {
        book.addGenre(genre);
        bookRep.save(book);
    }

    @Override
    public void addGenre(String bookId, String genreId) {
        Book book = bookRep.findById(bookId);
        Genre genre = genreRep.findById(genreId);
        book.addGenre(genre);
        bookRep.save(book);
    }

    @Override
    public Set<Genre> getGenres(Book book) {
        return book.getGenres();
    }

    @Override
    public Set<Genre> getGenres(String bookId) {
        Book book = bookRep.findById(bookId);
        return book.getGenres();
    }

    @Override
    public Set<Author> getAuthors(String bookId) {
        Book book = bookRep.findById(bookId);
        return book.getAuthors();
    }

    @Override
    public void addComment(String bookId, String text) {
        Book book = bookRep.findById(bookId);
        book.addComment(new Comment(text));
        bookRep.save(book);
    }

    @Override
    public List<Comment> getComments(String bookId) {
        Book book = bookRep.findById(bookId);
        return book.getComments();
    }
}
