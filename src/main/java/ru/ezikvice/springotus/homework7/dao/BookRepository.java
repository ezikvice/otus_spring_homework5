package ru.ezikvice.springotus.homework7.dao;

import org.springframework.data.repository.CrudRepository;
import ru.ezikvice.springotus.homework7.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book save(Book book);

    Book findById(int id);
}
