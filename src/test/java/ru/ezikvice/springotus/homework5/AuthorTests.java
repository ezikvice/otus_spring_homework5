package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.service.AuthorService;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {

    @Autowired
    AuthorService service;

    private static Author testAuthor = new Author("Test Author");

    @Test
    public void addingAuthor() {
        service.add(testAuthor);
        Author jdbcAuthor = service.findById(testAuthor.getId());
        Assert.assertEquals(jdbcAuthor, testAuthor);
    }

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author( "Test Name Author");
        service.add(testNameAuthor);
        Set<Author> foundAuthors = service.findByName("Test Name Author");
        Assert.assertTrue(foundAuthors.contains(testNameAuthor));
    }
}
