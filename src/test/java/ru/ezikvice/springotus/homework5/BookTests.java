package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;
import ru.ezikvice.springotus.homework5.service.AuthorService;
import ru.ezikvice.springotus.homework5.service.BookService;
import ru.ezikvice.springotus.homework5.service.GenreService;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {


    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @Autowired
    GenreService genreService;

    @Test
    public void addingBook() {
        Book testBook = new Book(42, "The Book", "test book");
        bookService.add(testBook);
        Book foundBook = bookService.findById(42);
        Assert.assertEquals(foundBook, testBook);
    }

    @Test
    public void addingGenresToBook() {
        Genre firstGenre = new Genre("First genre", "First Genre Description");
        Genre secondGenre = new Genre("Second genre", "Second genre description");
        Book bookWithGenres = new Book(44, "book with genres", "two genres");

        bookWithGenres.addGenre(firstGenre);
        bookWithGenres.addGenre(secondGenre);
        bookService.add(bookWithGenres);

        Set<Genre> foundGenres = bookService.getGenres(44);
        Assert.assertTrue(foundGenres.contains(firstGenre));
        Assert.assertTrue(foundGenres.contains(secondGenre));
    }

    @Test
    public void addingAuthorsToBook() {
        Author firstAuthor = new Author("mr. First");
        Author secondAuthor = new Author("mr. Second");
        Book bookWithAuthors = new Book(45, "book with authors", "two authors");

        bookWithAuthors.addAuthor(firstAuthor);
        bookWithAuthors.addAuthor(secondAuthor);
        bookService.add(bookWithAuthors);

        Set<Author> foundAuthors = bookService.getAuthors(45);
        Assert.assertTrue(foundAuthors.contains(firstAuthor));
        Assert.assertTrue(foundAuthors.contains(secondAuthor));
    }
}
