package ru.ezikvice.springotus.homework13.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
@Entity
@ToString(exclude = {"comments"})
@EqualsAndHashCode(exclude = "comments")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sid")
    @Getter
    @Setter
    private long sid;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private Set<Author> authors = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinTable(name = "book_genre",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @Getter
    @Setter
    private Set<Genre> genres = new HashSet<>();

    @Getter
    @Setter
    private List<Comment> comments = new ArrayList();

    public Book(String id, String name, String description) {
        this(name, description);
        this.id = id;
    }

    public Book(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
