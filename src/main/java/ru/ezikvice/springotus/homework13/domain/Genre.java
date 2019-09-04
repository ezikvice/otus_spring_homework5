package ru.ezikvice.springotus.homework13.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
@Document
@Data
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue
    @Column(name = "sid")
    private long sid;

    private String id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Genre(String id, String name, String description) {
        this(name, description);
        this.id = id;
    }
}
