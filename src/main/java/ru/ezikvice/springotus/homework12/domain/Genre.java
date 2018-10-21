package ru.ezikvice.springotus.homework12.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Genre {

    @Id
    private String id;

    private String name;

    private String description;

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Genre(String id, String name, String description) {
        this(name, description);
        this.id = id;
    }
}
