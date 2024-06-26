package ru.education.aqajava.tests.lessons.lesson7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseTests {

    String pathToDB = getClass().getClassLoader().getResource("sqlite/chinook.db").getPath();
    private final String dbUrl = "jdbc:sqlite:" + pathToDB;

    @Test
    void getGenresTest() {
        List<String> allGenres = getAllGenres();
        System.out.println(allGenres);
        Assertions.assertFalse(allGenres.isEmpty());
    }

    @Test
    void addNewGenreTest() {
        insertNewGenre("Nu");
        Assertions.assertTrue(getAllGenres().contains("Nu"));
    }

    @Test
    void deleteGenreTest() {
        deleteGenre("Jazz");
        Assertions.assertFalse(getAllGenres().contains("Jazz"));
    }


    private List<String> getAllGenres() {
        String query = "SELECT * FROM Genres";
        List<String> genres = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbUrl);
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                genres.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    private void insertNewGenre(String genre) {
        String query = "INSERT INTO Genres(Name) VALUES(?)";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, genre);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteGenre(String genre) {
        String query = "DELETE FROM Genres WHERE Name=?";

        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, genre);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
