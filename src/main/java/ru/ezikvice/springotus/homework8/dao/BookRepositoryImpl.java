package ru.ezikvice.springotus.homework8.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework8.domain.Author;
import ru.ezikvice.springotus.homework8.domain.Book;
import ru.ezikvice.springotus.homework8.domain.Comment;
import ru.ezikvice.springotus.homework8.domain.Genre;

@Repository
public class BookRepositoryImpl implements BookRepositoryCustom {

    @Autowired
    private MongoTemplate mt;

    @Override
    public void saveAuthor(Book book, Author author) {
        book.addAuthor(author);
        mt.save(book);
    }

    @Override
    public void saveGenre(Book book, Genre genre) {
        book.addGenre(genre);
        mt.save(book);
    }

    @Override
    public void saveComment(Book book, Comment comment) {
        book.addComment(comment);
        mt.save(book);
    }
}
