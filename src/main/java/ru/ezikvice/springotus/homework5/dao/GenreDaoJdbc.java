package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GenreDaoJdbc implements GenreDao {

    private final JdbcOperations jdbc;

    public GenreDaoJdbc(JdbcOperations jdbcOperations) {
        jdbc = jdbcOperations;
    }


    @Override
    public void set(Genre genre) {
        if (genre.getId() != 0) {
            jdbc.update("insert into genre (id, name, description) values(?, ?, ?)",
                    genre.getId(), genre.getName(), genre.getDescription());
        } else {
            jdbc.update("insert into genre (name, description) values(?, ?)",
                    genre.getName(), genre.getDescription());
        }
    }

    @Override
    public Genre getById(int id) {
        return jdbc.queryForObject("select * from genre where id = ?", new Object[]{id}, new GenreMapper());
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(id) from genre", Integer.class);
    }

    private static class GenreMapper implements RowMapper<Genre> {

        @Override
        public Genre mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            return new Genre(id, name, description);
        }
    }

}
