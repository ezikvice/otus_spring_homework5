package ru.ezikvice.springotus.homework11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.domain.Book;
import ru.ezikvice.springotus.homework11.domain.Genre;
import ru.ezikvice.springotus.homework11.service.AuthorService;
import ru.ezikvice.springotus.homework11.service.BookService;
import ru.ezikvice.springotus.homework11.service.GenreService;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTests {


    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GenreService genreService;

    @Test
    public void addingBook() {
        Book testBook = new Book("The Book", "test book");
        bookService.add(testBook);
        Book foundBook = bookService.findById(testBook.getId());
        assertEquals(foundBook, testBook);
    }

    @Test
    public void addingGenresToBook() {
        Genre firstGenre = new Genre("First genre", "First Genre Description");
        Genre secondGenre = new Genre("Second genre", "Second genre description");
        Book bookWithGenres = new Book("book with genres", "two genres");

        bookWithGenres.addGenre(firstGenre);
        bookWithGenres.addGenre(secondGenre);
        bookService.add(bookWithGenres);

        Set<Genre> foundGenres = bookService.getGenres(bookWithGenres.getId());
        assertTrue(foundGenres.contains(firstGenre));
        assertTrue(foundGenres.contains(secondGenre));
    }

    @Test
    public void addingAuthorsToBook() {
        Author firstAuthor = new Author("mr. First");
        Author secondAuthor = new Author("mr. Second");
        Book bookWithAuthors = new Book("book with authors", "two authors");

        bookWithAuthors.addAuthor(firstAuthor);
        bookWithAuthors.addAuthor(secondAuthor);
        bookService.add(bookWithAuthors);

        Set<Author> foundAuthors = bookService.getAuthors(bookWithAuthors.getId());
        assertTrue(foundAuthors.contains(firstAuthor));
        assertTrue(foundAuthors.contains(secondAuthor));
    }
}
