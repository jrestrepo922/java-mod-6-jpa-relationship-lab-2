package org.example;

import org.example.models.Games;
import org.example.models.Reviews;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create Game
        Games game = new Games();
        game.setTitle("Elden Ring");
        game.setGenre("RPG");
        game.setPlatform("Computer, PS5");
        game.setPrice(70);
        game.setCreated_at(LocalDate.of(2022, 2, 25));
        game.setUpdated_at(LocalDate.of(2022, 3, 25));

        // Create reviews
        Reviews review1 = new Reviews();
        review1.setScore(95);
        review1.setComment("Wonderful Game");
        review1.setCreated_at(LocalDate.of(2022, 2, 25));
        review1.setUpdated_at(LocalDate.of(2022, 3, 26));
        Reviews review2 = new Reviews();
        review2.setScore(100);
        review2.setComment("Best Game");
        review2.setCreated_at(LocalDate.of(2022, 2, 20));
        review2.setUpdated_at(LocalDate.of(2022, 2, 26));

        game.addReview(review1);
        game.addReview(review2);

        review1.setGames(game);
        review2.setGames(game);

        // create EntityManager
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // access transaction object
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(game);
        entityManager.persist(review1);
        entityManager.persist(review2);
        transaction.commit();

        // close entity manager
        entityManager.close();
        entityManagerFactory.close();
    }
}