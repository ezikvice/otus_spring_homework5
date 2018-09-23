package ru.ezikvice.springotus.homework5.dao;

import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.BookAuthor;

import java.util.List;

public interface BookAuthorDao {

    void add(Book book, Author author);

    void add(int bookId, int authorId);

    BookAuthor getById(int id);

    List<Author> getByBook(Book book);
}
