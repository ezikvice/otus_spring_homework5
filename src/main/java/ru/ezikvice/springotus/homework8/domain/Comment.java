package ru.ezikvice.springotus.homework8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Comment {

    @Id
    private String id;

    private String text;

    public Comment(String text) {
        this.text = text;
    }
}
