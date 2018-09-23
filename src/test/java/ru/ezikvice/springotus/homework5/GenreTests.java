package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;
import ru.ezikvice.springotus.homework5.service.BookService;
import ru.ezikvice.springotus.homework5.service.GenreService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenreTests {

    @Autowired
    GenreService genreService;

    private static final Genre testGenre = new Genre(42, "test genre", "test genre description");

    @Test
    public void addGenreTest() {
        genreService.add(testGenre);
        Genre jdbcGenre = genreService.find(42);
        Assert.assertEquals(jdbcGenre, testGenre);
    }

}
