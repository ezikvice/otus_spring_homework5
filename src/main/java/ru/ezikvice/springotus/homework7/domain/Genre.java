package ru.ezikvice.springotus.homework7.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
@ToString(exclude = "books")
@EqualsAndHashCode(exclude = "books")
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

    @ManyToMany(mappedBy = "genres")
    @Getter
    @Setter
    private Set<Book> books;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Genre(int id, String name, String description) {
        this(name, description);
        this.id = id;
    }
}
