package ru.ezikvice.springotus.homework5.service;

import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework5.dao.BookDao;
import ru.ezikvice.springotus.homework5.dao.BookGenreDao;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.util.HashSet;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao dao;
    private final BookGenreDao bookGenreDao;

    public BookServiceImpl(BookDao dao, BookGenreDao bookGenreDao) {
        this.dao = dao;
        this.bookGenreDao = bookGenreDao;
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

        return book;
    }

    @Override
    public void addAuthor(Author author) {

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
        return null;
    }
}
