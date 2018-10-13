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
import ru.ezikvice.springotus.homework8.dao.BookRepository;
import ru.ezikvice.springotus.homework8.domain.Book;
import ru.ezikvice.springotus.homework8.domain.Comment;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
@ComponentScan("ru.ezikvice.springotus.homework8.dao")
public class CommentDaoTests {

    @Autowired
    MongoTemplate em;

    @Autowired
    private BookRepository rep;

    @Test
    public void savingCommentToBook() {
        Book book = new Book("Very Popular Book", "Book with comments");
        Comment comment = new Comment("Test Name Author");
        book.addComment(comment);
        rep.save(book);
        Assert.assertTrue(book.getComments().contains(comment));
    }
}
