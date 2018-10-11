package ru.ezikvice.springotus.homework5.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
@ToString(exclude = "books")
@EqualsAndHashCode(exclude = "books")
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @ManyToMany(mappedBy = "authors")
    @Getter
    @Setter
    private Set<Book> books;

    public Author(String name) {
        this.name = name;
    }

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
