package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.service.AuthorService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {

    @Autowired
    AuthorService service;

    private static final Author testAuthor = new Author(42,"Test Author");

    @Test
    public void addingAuthor() {
        service.add(testAuthor);
        Author jdbcAuthor = service.findById(42);
        Assert.assertEquals(jdbcAuthor, testAuthor);
    }

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author(123, "Test Name Author");
        service.add(testNameAuthor);
        List<Author> foundAuthors = service.findByName("Test Name Author");
        Assert.assertTrue(foundAuthors.contains(testNameAuthor));
    }
}
