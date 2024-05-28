package ru.education.aqajava.tests.lessons.lesson9;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "genres")
public class Genres {
    @Id
    @Column(name = "GenreId")
    private Integer id;

    @Column(name = "Name")
    private String name;
}
