package ru.ezikvice.springotus.homework5.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="book_id")
    private Book book;

    public Comment(Book book, String text) {
        this.book = book;
        this.text = text;
    }
}
