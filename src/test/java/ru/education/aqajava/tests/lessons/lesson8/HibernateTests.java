package ru.education.aqajava.tests.lessons.lesson8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.education.aqajava.tests.lessons.lesson8.helper.DbHelper;
import ru.education.aqajava.tests.lessons.lesson8.model.Genres;

import java.util.List;

public class HibernateTests {

    @Test
    public void getAllGenresTest() {
        DbHelper dbHelper = new DbHelper();

        List<Genres> allGenres = dbHelper.getAllGenres();
        for (Genres genre : allGenres) {
            System.out.println(genre.getName());
        }

        Assertions.assertFalse(allGenres.isEmpty());
    }

    @Test
    public void addNewGenreTest() {
        DbHelper dbHelper = new DbHelper();
        dbHelper.addNewGenre("Nu");

        List<Genres> allGenres = dbHelper.getAllGenres();
        boolean containsNu = false;
        for (Genres genre : allGenres) {
            String name = genre.getName();
            if (name.contains("Nu")) {
                containsNu = true;
                break;
            }
        }

        Assertions.assertTrue(containsNu);
    }

    @Test
    public void deleteGenreTest() {
        DbHelper dbHelper = new DbHelper();
        dbHelper.deleteGenre("Jazz");

        List<Genres> allGenres = dbHelper.getAllGenres();
        for (Genres genre : allGenres) {
            System.out.println(genre.getName());
        }

        Assertions.assertFalse(allGenres.contains("Jazz"));
    }

}
