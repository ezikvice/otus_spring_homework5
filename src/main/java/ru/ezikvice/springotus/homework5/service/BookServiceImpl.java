package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.AuthorRepository;
import ru.ezikvice.springotus.homework5.dao.BookRepository;
import ru.ezikvice.springotus.homework5.dao.GenreRepository;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Comment;
import ru.ezikvice.springotus.homework5.domain.Genre;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRep;
    private final GenreRepository genreRep;
    private final AuthorRepository authorRep;

    public BookServiceImpl(BookRepository bookRep, GenreRepository genreRep, AuthorRepository authorRep) {
        this.bookRep = bookRep;
        this.genreRep = genreRep;
        this.authorRep = authorRep;
    }

    @Override
    public int count() {
        return bookRep.count();
    }

    @Override
    public void add(Book book) {
        bookRep.save(book);
    }

    @Override
    public Book findById(int bookId) {
        return bookRep.getById(bookId);
    }

    @Override
    public void addAuthor(Book book, Author author) {
        bookRep.saveAuthor(book, author);
    }

    @Override
    public void addAuthor(int bookId, int authorId) {
        Book book = bookRep.getById(bookId);
        Author author = authorRep.findById(authorId);
        bookRep.saveAuthor(book, author);
    }

    @Override
    public void addGenre(Book book, Genre genre) {
        bookRep.saveGenre(book, genre);
    }

    @Override
    public void addGenre(int bookId, int genreId) {
        Book book = bookRep.getById(bookId);
        Genre genre = genreRep.findById(genreId);
        bookRep.saveGenre(book, genre);
    }

    @Override
    public Set<Genre> getGenres(Book book) {
        return book.getGenres();
    }

    @Override
    public Set<Genre> getGenres(int bookId) {
        Book book = bookRep.getById(bookId);
        return book.getGenres();
    }

    @Override
    public Set<Author> getAuthors(int bookId) {
        Book book = bookRep.getById(bookId);
        return book.getAuthors();
    }

    @Override
    public void addComment(int bookId, String text) {
        Book book = bookRep.getById(bookId);
        Comment comment = new Comment(book, text);
        bookRep.saveComment(book, comment);
    }

    @Override
    public Set<Comment> getComments(int bookId){
        Book book = bookRep.getById(bookId);
        return book.getComments();
    }
}
