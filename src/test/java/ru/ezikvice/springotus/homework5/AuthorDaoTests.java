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
import ru.ezikvice.springotus.homework5.dao.AuthorRepositoryJdbc;
import ru.ezikvice.springotus.homework5.domain.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ComponentScan("ru.ezikvice.springotus.homework5.dao")
public class AuthorDaoTests {

    @Autowired
    TestEntityManager em;

    @Autowired
    private AuthorRepositoryJdbc rep;

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author("Test Name Author");
        em.persist(testNameAuthor);
//        Set<Author> foundAuthors = service.findByName("Test Name Author");
        Assert.assertTrue(rep.findByName("Test Name Author").contains(testNameAuthor));
    }
}
