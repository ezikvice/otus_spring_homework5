package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookAuthorDaoJdbc implements BookAuthorDao {

    private final JdbcOperations jdbc;

    public BookAuthorDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void add(Book book, Author author) {
        jdbc.update("insert into book_author (book_id, author_id) values (?, ?)",
                book.getId(), author.getId());
    }

    @Override
    public void add(int bookId, int authorId) {
        jdbc.update("insert into book_author (book_id, author_id) values (?, ?)",
                bookId, authorId);
    }

    @Override
    public BookAuthor getById(int id) {
        return jdbc.queryForObject("select * from book_author where id = ?", new Object[]{id}, new BookAuthorMapper());
    }

    @Override
    public List<Author> getByBook(Book book) {

        List<Author> authors = new ArrayList<>();
        List<Map<String, Object>> jdbcList = jdbc.queryForList("select * from author " +
                "where id in (" +
                " select author_id from book_author " +
                "   where book_id = ?)", new Object[]{book.getId()});

        for (Map row : jdbcList) {
            authors.add(new Author(
                    (Integer)row.get("id"),
                    (String)row.get("name")
                    ));
        }

        return authors;
    }

    private static class BookAuthorMapper implements RowMapper<BookAuthor> {
        @Override
        public BookAuthor mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            int bookId = resultSet.getInt("book_id");
            int authorId = resultSet.getInt("author_id");
            return new BookAuthor(id, bookId, authorId);
        }
    }

}
