package ru.ezikvice.springotus.homework13.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
public class Comment {

    @Id
    private String id;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="book_id")
    private Book book;

    public Comment(String text) {
        this.text = text;
    }
}
