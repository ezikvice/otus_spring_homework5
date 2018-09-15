package ru.ezikvice.springotus.homework5;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.ezikvice.springotus.homework5.dao.GenreDao;
import ru.ezikvice.springotus.homework5.domain.Genre;

import java.sql.SQLException;

@SpringBootApplication
public class Homework5Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(Homework5Application.class);

        GenreDao dao = context.getBean(GenreDao.class);
        dao.set(new Genre(1, "sci-fi", "Science Fiction"));

        System.out.println(dao.getById(1));
        Console.main(args);

    }
}
