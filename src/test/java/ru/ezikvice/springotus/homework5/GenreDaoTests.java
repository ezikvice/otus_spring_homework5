package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.dao.GenreRepositoryJdbc;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Genre;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ComponentScan("ru.ezikvice.springotus.homework5.dao")
public class GenreDaoTests {

    @Autowired
    TestEntityManager em;

    @Autowired
    private GenreRepositoryJdbc rep;

    @Test
    public void findingGenreById() {
         Genre testGenre = new Genre("Testing Software", "It`s all about us");
        em.persist(testGenre);
        Assert.assertEquals(rep.findById(testGenre.getId()), testGenre);
    }
}
