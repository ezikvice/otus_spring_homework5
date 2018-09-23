package ru.ezikvice.springotus.homework5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework5ApplicationTests {

    @Autowired
    BookService bookService;

    @Test
    public void checkBook() {
        Book book = bookService.findById(1);
        Assert.assertEquals(book.getId(), 1);
    }

}
