package ru.education.aqajava.tests.lessons.lesson8.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GenreId")
    private Integer id;

    @Column(name = "Name")
    private String name;
}
