package ru.education.aqajava.lessons.api.lesson8.helper;

import ru.education.aqajava.lessons.api.lesson8.model.Genres;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DbHelper {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
    private final EntityManager entityManager = emf.createEntityManager();

    public List<Genres> getAllGenres() {
        return entityManager
                .createQuery("SELECT g FROM Genres g", Genres.class)
                .getResultList();
    }

    public void addNewGenre(String newGenreName) {
        Genres newGenre = new Genres();
        newGenre.setName(newGenreName);

        entityManager.getTransaction().begin();
        entityManager.persist(newGenre);
        entityManager.getTransaction().commit();
    }

    public void deleteGenre(String genreName) {
        entityManager.getTransaction().begin();
        Genres genre = entityManager.createQuery("SELECT g FROM Genres g WHERE g.name = '" + genreName + "'", Genres.class)
                .getSingleResult();
        entityManager.remove(genre);
        entityManager.getTransaction().commit();
    }
}
