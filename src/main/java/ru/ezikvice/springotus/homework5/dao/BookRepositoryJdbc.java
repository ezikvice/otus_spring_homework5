package ru.ezikvice.springotus.homework5.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ezikvice.springotus.homework5.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class BookRepositoryJdbc implements BookRepository {

    //    private final JdbcOperations jdbc;
    @PersistenceContext
    private EntityManager em;

//    public BookRepositoryJdbc(JdbcOperations jdbc) {
//        this.jdbc = jdbc;
//    }

    @Override
    public int count() {
        Query query = em.createQuery("SELECT COUNT(b.id) FROM BOOK b");

        return (int) query.getSingleResult();
    }

    @Override
    public void insert(Book book) {
        if (book.getId() == 0) {
            jdbc.update("insert into book (id, name, description) values(?, ?, ?)",
                    book.getId(), book.getName(), book.getDescription());
        } else {
            jdbc.update("insert into book (id, name, description) values(?, ?, ?)",
                    book.getId(), book.getName(), book.getDescription());
        }
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
