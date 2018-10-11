package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.dao.AuthorRepositoryJdbc;
import ru.ezikvice.springotus.homework5.domain.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class AuthorDaoTests {

    @Autowired
    TestEntityManager em;

    @Autowired
    private AuthorRepositoryJdbc rep;

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author(123, "Test Name Author");
        em.persist(testNameAuthor);
//        Set<Author> foundAuthors = service.findByName("Test Name Author");
        Assert.assertEquals(testNameAuthor, rep.findByName("Test Name Author"));
    }
}
