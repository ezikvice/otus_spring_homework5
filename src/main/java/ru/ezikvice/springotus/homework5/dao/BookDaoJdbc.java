package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BookDaoJdbc implements BookDao {

    private final JdbcOperations jdbc;

    public BookDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(id) from book", Integer.class);
    }

    @Override
    public void insert(Book book) {
        jdbc.update("insert into book (id, name, description) values(?, ?, ?)",
                book.getId(), book.getName(), book.getDescription());
    }

    @Override
    public Book getById(int id) {
        return jdbc.queryForObject("select * from book where id = ?", new Object[]{id}, new BookMapper());
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            return new Book(id, name, description);
        }
    }


}
