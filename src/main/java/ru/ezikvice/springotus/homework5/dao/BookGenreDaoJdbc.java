package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Book;
import ru.ezikvice.springotus.homework5.domain.BookGenre;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        return jdbc.queryForList("select * from genre where book_id = ?", new Object[]{book.getId()}, Book.class);
    }

    private static class BookGenreMapper implements RowMapper<BookGenre> {

        @Override
        public BookGenre mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            int bookId = resultSet.getInt("book_id");
            int genreId = resultSet.getInt("genre_id");
            BookGenre bookGenre = new BookGenre(id, bookId, genreId);

            return bookGenre;

        }
    }




}
