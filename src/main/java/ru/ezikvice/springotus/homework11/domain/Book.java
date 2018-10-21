package ru.ezikvice.springotus.homework11.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document
@ToString(exclude = {"comments"})
@EqualsAndHashCode(exclude = "comments")
@NoArgsConstructor
public class Book {

    @Id
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
    private Set<Author> authors = new HashSet<>();

    @Getter
    @Setter
    private Set<Genre> genres = new HashSet<>();

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
