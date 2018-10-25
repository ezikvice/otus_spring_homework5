package ru.ezikvice.springotus.homework12;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework12.dao.AuthorRepository;
import ru.ezikvice.springotus.homework12.domain.Author;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
@ComponentScan("ru.ezikvice.springotus.homework12.dao")
public class AuthorDaoTests {

    @Autowired
    private MongoTemplate mt;

    @Autowired
    private AuthorRepository rep;

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author("Test Name Author");
        mt.save(testNameAuthor);
        assertTrue(rep.findByName("Test Name Author").contains(testNameAuthor));
    }
}
