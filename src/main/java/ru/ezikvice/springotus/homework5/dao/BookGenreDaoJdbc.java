package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.BookGenre;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BookGenreDaoJdbc implements BookGenreDao {

    private final JdbcOperations jdbc;

    public BookGenreDaoJdbc(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void add(Book book, Genre genre) {
        jdbc.update("insert into book_genre (book_id, genre_id) values (?, ?)",
                book.getId(), genre.getId());
    }

    @Override
    public void add(int bookId, int genreId) {
        jdbc.update("insert into book_genre (book_id, genre_id) values (?, ?)",
                bookId, genreId);
    }

    @Override
    public BookGenre getById(int id) {
        return jdbc.queryForObject("select * from book_genre where id = ?", new Object[]{id}, new BookGenreMapper());
    }

    @Override
    public List<Genre> getByBook(Book book) {

        List<Genre> genres = new ArrayList<>();
        List<Map<String, Object>> jdbcList = jdbc.queryForList("select * from genre " +
                "where id in (" +
                " select genre_id from book_genre " +
                "   where book_id = ?)", new Object[]{book.getId()});

        for (Map row : jdbcList) {
            genres.add(new Genre(
                    (Integer)row.get("id"),
                    (String)row.get("name"),
                    (String)row.get("description")
                    ));
        }

        return genres;
//        return jdbc.queryForList("select * from genre " +
//                "where id in (" +
//                " select genre_id from book_genre " +
//                "   where book_id = ?)", new Object[]{book.getId()}, Genre.class);
    }

    private static class BookGenreMapper implements RowMapper<BookGenre> {

        @Override
        public BookGenre mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            int bookId = resultSet.getInt("book_id");
            int genreId = resultSet.getInt("genre_id");
            return new BookGenre(id, bookId, genreId);
        }
    }


}
