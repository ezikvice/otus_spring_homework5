package ru.ezikvice.springotus.homework7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework7.domain.Genre;
import ru.ezikvice.springotus.homework7.service.GenreService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GenreTests {

    @Autowired
    GenreService genreService;

    @Test
    public void addingGenre() {
        Genre testGenre = new Genre("test genre", "test genre description");
        genreService.add(testGenre);
        Genre jdbcGenre = genreService.find(testGenre.getId());
        Assert.assertEquals(jdbcGenre, testGenre);
    }
}
