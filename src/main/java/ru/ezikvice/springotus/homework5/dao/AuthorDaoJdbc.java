package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AuthorDaoJdbc implements AuthorDao {
    private final JdbcOperations jdbc;

    public AuthorDaoJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(id) from author", Integer.class);
    }

    @Override
    public void insert(Author author) {
        jdbc.update("insert into author (name) values (?)", author.getName());
    }

    @Override
    public Author findById(int id) {
        return jdbc.queryForObject("select * from author where id = ?", new Object[]{id}, new AuthorMapper());
    }

    @Override
    public Author findByName(String name) {
        return jdbc.queryForObject("select * from author where name like ?", new Object[]{name}, new AuthorMapper());
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
