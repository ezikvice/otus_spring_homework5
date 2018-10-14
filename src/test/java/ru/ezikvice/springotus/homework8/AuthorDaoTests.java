package ru.ezikvice.springotus.homework8;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework8.dao.AuthorRepository;
import ru.ezikvice.springotus.homework8.domain.Author;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
@ComponentScan("ru.ezikvice.springotus.homework8.dao")
public class AuthorDaoTests {

    @Autowired
    MongoTemplate em;

    @Autowired
    private AuthorRepository rep;

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author("Test Name Author");
        em.save(testNameAuthor);
        Assert.assertTrue(rep.findByName("Test Name Author").contains(testNameAuthor));
    }
}
