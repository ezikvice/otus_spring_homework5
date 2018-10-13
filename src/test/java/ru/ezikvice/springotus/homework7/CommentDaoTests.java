package ru.ezikvice.springotus.homework7;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework7.dao.BookRepository;
import ru.ezikvice.springotus.homework7.dao.BookRepositoryCustom;
import ru.ezikvice.springotus.homework7.domain.Book;
import ru.ezikvice.springotus.homework7.domain.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ComponentScan("ru.ezikvice.springotus.homework7.dao")
public class CommentDaoTests {

    @Autowired
    TestEntityManager em;

    @Autowired
    private BookRepository rep;

    @Autowired
    private BookRepositoryCustom repCustom;

    @Test
    public void savingCommentToBook() {
        Book book = new Book("Very Popular Book", "Book with comments");
        Comment comment = new Comment(book, "Test Name Author");
        repCustom.saveComment(book, comment);
        Assert.assertTrue(book.getComments().contains(comment));
    }
}
