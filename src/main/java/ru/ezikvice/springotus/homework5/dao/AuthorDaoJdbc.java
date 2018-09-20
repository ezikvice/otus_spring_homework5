package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Author;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDaoJdbc implements AuthorDao {
    private final JdbcOperations jdbc;

    public AuthorDaoJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public void insert(Author author) {
        jdbc.update("insert into author (id, name) values (?, ?)", author.getId(), author.getName());
    }

    @Override
    public Author findById(int id) {
        return null;
    }

    @Override
    public Author findByName(String name) {
        return null;
    }

    @Override
    public List<Author> findByGenre(Genre genre) {
        return null;
    }

    @Override
    public List<Author> findByBook(Book book) {
        return null;
    }

    private static class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }

}
