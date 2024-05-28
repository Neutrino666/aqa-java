package ru.education.aqajava.tests.lessons.lesson9;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Hibernate {

    @Test
    public void printAllGenres() {
        DbHelper dbHelper = new DbHelper();

        List<Genres> allGenres = dbHelper.getAllGenres();

        for (Genres genre : allGenres) {
            System.out.println(genre.getName());
        }
    }

    @Test
    public void addNewGenre() {
        DbHelper dbHelper = new DbHelper();

        dbHelper.addNewGenre("Nu");

        List<Genres> allGenres = dbHelper.getAllGenres();
        for (Genres genre : allGenres) {
            System.out.println(genre.getName());
        }
    }

    @Test
    public void deleteGenre() {
        DbHelper dbHelper = new DbHelper();

        dbHelper.deleteGenre("Nu");

        List<Genres> allGenres = dbHelper.getAllGenres();
        for (Genres genre : allGenres) {
            System.out.println(genre.getName());
        }
    }

}
