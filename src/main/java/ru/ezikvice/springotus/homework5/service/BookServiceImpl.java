package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.AuthorRepository;
import ru.ezikvice.springotus.homework5.dao.BookRepository;
import ru.ezikvice.springotus.homework5.dao.BookGenreDao;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRep;
    private final BookGenreDao bookGenreDao;
    private final AuthorRepository authorRep;

    public BookServiceImpl(BookRepository bookRep, BookGenreDao bookGenreDao, AuthorRepository authorRep) {
        this.bookRep = bookRep;
        this.bookGenreDao = bookGenreDao;
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
        Book book = bookRep.getById(bookId);
        return book;
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
        bookGenreDao.add(book, genre);
    }

    @Override
    public void addGenre(int bookId, int genreId) {
        bookGenreDao.add(bookId, genreId);
    }

    @Override
    public List<Genre> getGenres(Book book) {
        return bookGenreDao.getByBook(book);
    }

    @Override
    public List<Genre> getGenres(int bookId) {
        Book book = bookRep.getById(bookId);
        return bookGenreDao.getByBook(book);
    }

    @Override
    public List<Author> getAuthors(int bookId) {
        Book book = bookRep.getById(bookId);
        return bookAuthorDao.getByBook(book);
    }
}
