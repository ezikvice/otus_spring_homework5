package ru.ezikvice.springotus.homework13;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework13.dao.BookRepository;
import ru.ezikvice.springotus.homework13.domain.Book;
import ru.ezikvice.springotus.homework13.domain.Comment;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataMongoTest
@ComponentScan("ru.ezikvice.springotus.homework13.dao")
public class CommentDaoTests {

    @Autowired
    private MongoTemplate mt;

    @Autowired
    private BookRepository rep;

    @Test
    public void savingCommentToBook() {
        Book book = new Book("Very Popular Book", "Book with comments");
        Comment comment = new Comment("Test Name Author");
        book.addComment(comment);
        rep.save(book);
        assertTrue(book.getComments().contains(comment));
    }
}
