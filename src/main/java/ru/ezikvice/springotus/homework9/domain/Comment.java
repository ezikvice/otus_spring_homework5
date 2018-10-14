package ru.ezikvice.springotus.homework9.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
