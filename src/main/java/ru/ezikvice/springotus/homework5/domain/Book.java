package ru.ezikvice.springotus.homework5.domain;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "book")
@ToString(exclude = {"comments"})
@EqualsAndHashCode(exclude = "comments")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private int id;

    @Column
    @Getter
    @Setter
    private String name;

    @Column
    @Getter
    @Setter
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @Getter
    @Setter
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

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "book")
    @Getter
    @Setter
    private List<Comment> comments = new ArrayList();

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
