package ru.ezikvice.springotus.homework7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ezikvice.springotus.homework7.dao.AuthorRepository;
import ru.ezikvice.springotus.homework7.dao.BookRepository;
import ru.ezikvice.springotus.homework7.dao.BookRepositoryCustom;
import ru.ezikvice.springotus.homework7.dao.GenreRepository;
import ru.ezikvice.springotus.homework7.domain.Author;
import ru.ezikvice.springotus.homework7.domain.Book;
import ru.ezikvice.springotus.homework7.domain.Comment;
import ru.ezikvice.springotus.homework7.domain.Genre;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
//@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRep;
    @Autowired
    private BookRepositoryCustom bookRepCustom;
    @Autowired
    private GenreRepository genreRep;
    @Autowired
    private AuthorRepository authorRep;

    @Override
    public long count() {
        return bookRep.count();
    }

    @Override
    public void add(Book book) {
        bookRep.save(book);
    }

    @Override
    public Book findById(int bookId) {
        return bookRep.findById(bookId);
    }

    @Override
    public void addAuthor(Book book, Author author) {
        bookRepCustom.saveAuthor(book, author);
    }

    @Override
    public void addAuthor(int bookId, int authorId) {
        Book book = bookRep.findById(bookId);
        Author author = authorRep.findById(authorId);
        bookRepCustom.saveAuthor(book, author);
    }

    @Override
    public void addGenre(Book book, Genre genre) {
        bookRepCustom.saveGenre(book, genre);
    }

    @Override
    public void addGenre(int bookId, int genreId) {
        Book book = bookRep.findById(bookId);
        Genre genre = genreRep.findById(genreId);
        bookRepCustom.saveGenre(book, genre);
    }

    @Override
    public Set<Genre> getGenres(Book book) {
        return book.getGenres();
    }

    @Override
    public Set<Genre> getGenres(int bookId) {
        Book book = bookRep.findById(bookId);
        return book.getGenres();
    }

    @Override
    public Set<Author> getAuthors(int bookId) {
        Book book = bookRep.findById(bookId);
        return book.getAuthors();
    }

    @Override
    public void addComment(int bookId, String text) {
        Book book = bookRep.findById(bookId);
        Comment comment = new Comment(book, text);
        bookRepCustom.saveComment(book, comment);
    }

    @Override
    public List<Comment> getComments(int bookId) {
        Book book = bookRep.findById(bookId);
        return book.getComments();
    }
}
