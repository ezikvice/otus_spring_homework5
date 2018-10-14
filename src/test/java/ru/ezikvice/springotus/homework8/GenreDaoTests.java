package ru.ezikvice.springotus.homework8;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework8.dao.GenreRepository;
import ru.ezikvice.springotus.homework8.domain.Genre;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
@ComponentScan("ru.ezikvice.springotus.homework8.dao")
public class GenreDaoTests {

    @Autowired
    MongoTemplate em;

    @Autowired
    private GenreRepository rep;

    @Test
    public void findingGenreById() {
        Genre testGenre = new Genre("Testing Software", "It`s all about us");
        em.save(testGenre);
        assertEquals(rep.findById(testGenre.getId()), testGenre);
    }
}
