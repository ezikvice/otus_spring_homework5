package ru.ezikvice.springotus.homework11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework11.domain.Author;
import ru.ezikvice.springotus.homework11.service.AuthorService;

import java.util.Set;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorTests {

    private static Author testAuthor = new Author("Test Author");
    @Autowired
    private AuthorService service;

    @Test
    public void addingAuthor() {
        service.save(testAuthor);
        Set<Author> foundAuthors = service.findByName(testAuthor.getName());
        assertTrue(foundAuthors.contains(testAuthor));
    }

    @Test
    public void findingAuthorByName() {
        Author testNameAuthor = new Author("Test Name Author");
        service.save(testNameAuthor);
        Set<Author> foundAuthors = service.findByName("Test Name Author");
        assertTrue(foundAuthors.contains(testNameAuthor));
    }
}
