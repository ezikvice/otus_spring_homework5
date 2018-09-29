package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.BookAuthorDao;
import ru.ezikvice.springotus.homework5.dao.BookRepository;
import ru.ezikvice.springotus.homework5.dao.BookGenreDao;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository dao;
    private final BookGenreDao bookGenreDao;
    private final BookAuthorDao bookAuthorDao;

    public BookServiceImpl(BookRepository dao, BookGenreDao bookGenreDao, BookAuthorDao bookAuthorDao) {
        this.dao = dao;
        this.bookGenreDao = bookGenreDao;
        this.bookAuthorDao = bookAuthorDao;
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public void add(Book book) {
        dao.insert(book);
    }

    @Override
    public Book findById(int bookId) {
        Book book = dao.getById(bookId);

        List<Genre> genres = bookGenreDao.getByBook(book);
        book.setGenres(genres);

        List<Author> authors = bookAuthorDao.getByBook(book);
        book.setAuthors(authors);

        return book;
    }

    @Override
    public void addAuthor(Book book, Author author) {
        bookAuthorDao.add(book, author);
    }

    @Override
    public void addAuthor(int bookId, int authorId) {
        bookAuthorDao.add(bookId, authorId);
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
        Book book = dao.getById(bookId);
        return bookGenreDao.getByBook(book);
    }

    @Override
    public List<Author> getAuthors(int bookId) {
        Book book = dao.getById(bookId);
        return bookAuthorDao.getByBook(book);
    }
}
