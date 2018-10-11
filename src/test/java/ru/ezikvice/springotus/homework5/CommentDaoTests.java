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
import ru.ezikvice.springotus.homework5.dao.BookRepositoryJdbc;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
@ComponentScan("ru.ezikvice.springotus.homework5.dao")
public class CommentDaoTests {

    @Autowired
    TestEntityManager em;

    @Autowired
    private BookRepositoryJdbc rep;

    @Test
    public void savingCommentToBook() {
        Book book = new Book("Very Popular Book", "Book with comments");
        Comment comment = new Comment(book, "Test Name Author");
        rep.saveComment(book, comment);
        Assert.assertTrue(book.getComments().contains(comment));
    }
}
