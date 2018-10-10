package ru.ezikvice.springotus.homework5.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    public Comment() {
    }

    public Comment(Book book, String text) {
        this.book = book;
        this.text = text;
    }

    public Comment(int id, Book book, String text) {
        this.id = id;
        this.book = book;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        return new EqualsBuilder()
                .append(getId(), comment.getId())
                .append(getText(), comment.getText())
                .append(getBook(), comment.getBook())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getText())
                .append(getBook())
                .toHashCode();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", book=" + book +
                '}';
    }
}
