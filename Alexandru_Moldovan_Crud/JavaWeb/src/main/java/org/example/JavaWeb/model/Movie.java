package org.example.JavaWeb.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Movie {
    private Long id;
    @Getter
    private String title;
    @Getter
    private String description;
    @Getter
    private int year;

    public Movie(String title, String description, int year) {
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public Movie(Long id, String title, String description, int year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }

}


