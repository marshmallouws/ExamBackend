/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;
import entities.Request;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Annika
 */
public class MovieDBFacade {

    private static MovieDBFacade instance;
    private static EntityManagerFactory emf;

    private MovieDBFacade() {
    }

    public static MovieDBFacade getMovieDBFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieDBFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void saveRequest(String username, MovieDTO m) {
        EntityManager em = getEntityManager();
        User user = user = em.find(User.class, username); // Null if not exists
        Movie movie = null;

        try {
            TypedQuery<Movie> tq
                    = em.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class);
            tq.setParameter("title", m.getTitle());
            movie = tq.getSingleResult();
        } catch (NoResultException e) {
            movie = new Movie(m.getTitle(), m.getYear(), m.getPlot(), m.getDirectors(), m.getGenres(), m.getCast(), m.getPoster());
        }

        try {
            Request req = new Request(movie, user);
            em.getTransaction().begin();
            em.merge(req);
            em.getTransaction().commit();
            System.out.println("TESTIIIIING");
        } finally {
            em.close();
        }

    }

    public MovieDTO findMovie(String title) {
        EntityManager em = getEntityManager();
        Movie movie = null;
        try {
            TypedQuery<Movie> tq
                    = em.createQuery("SELECT m FROM Movie m WHERE m.title = :title", Movie.class);
            tq.setParameter("title", title);
            movie = tq.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
        return new MovieDTO(movie);
    }
}
