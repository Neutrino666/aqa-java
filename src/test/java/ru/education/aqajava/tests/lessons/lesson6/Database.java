package ru.education.aqajava.tests.lessons.lesson6;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    String pathToDB = getClass().getClassLoader().getResource("sqlite/chinook.db").getPath();
    private final String dbUrl = "jdbc:sqlite:" + pathToDB;

    @Test
    void getGenre() {
        System.out.println(getAllGenres());
    }
    @Test
    void printGenres() {
        insertNewGenre("Nu");
        System.out.println(getAllGenres());
    }

    @Test
    void addNewGenre() {
        insertNewGenre("Nu");
        System.out.println(getAllGenres());
    }

    @Test
    void deleteGenre() {
        deleteGenre("Nu");
        System.out.println(getAllGenres());
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
