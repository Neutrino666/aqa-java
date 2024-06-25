package ru.education.aqajava.tests.lessons.lesson8;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DbHelper {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("chinook");
    private final EntityManager entityManager = emf.createEntityManager();

    public List<Genres> getAllGenres() {
        return entityManager
                .createQuery("SELECT g FROM Genres g")
                .getResultList();
    }

    public void addNewGenre(String newGenreName) {
        Genres newGenre = new Genres();
        newGenre.setId(11111);
        newGenre.setName(newGenreName);

        entityManager.getTransaction().begin();
        entityManager.persist(newGenre);
        entityManager.getTransaction().commit();
    }

    public void deleteGenre(String genreName) {
        entityManager.getTransaction().begin();
        Genres genre = entityManager.find(Genres.class, 11111);
        entityManager.remove(genre);
        entityManager.getTransaction().commit();
    }
}
