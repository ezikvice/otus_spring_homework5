package ru.ezikvice.springotus.homework13.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
@Document
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    @Column(name = "sid")
    private long sid;

    private String id;

    private String name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
