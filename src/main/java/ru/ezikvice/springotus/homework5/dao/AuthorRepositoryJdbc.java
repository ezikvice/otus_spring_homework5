package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorRepositoryJdbc implements AuthorRepository {
    private final JdbcOperations jdbc;

    public AuthorRepositoryJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(id) from author", Integer.class);
    }

    @Override
    public void insert(Author author) {
        if (author.getId() == 0) {
            jdbc.update("insert into author (name) values (?)", author.getName());
        } else {
            jdbc.update("insert into author (id, name) values (?, ?)", author.getId(), author.getName());
        }
    }

    @Override
    public Author findById(int id) {
        return jdbc.queryForObject("select * from author where id = ?", new Object[]{id}, new AuthorMapper());
    }

    @Override
    public List<Author> findByName(String name) {
        return jdbc.query("select * from author where name like ?", new Object[]{"%" + name + "%"}, new AuthorMapper());
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
