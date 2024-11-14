package org.example.nasa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.nasa.model.Asteroid;

import java.util.List;

public class AsteroidDaoImpl implements AsteroidDao {


    @Override
    public List<Asteroid> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        EntityManager manager = emf.createEntityManager();

        Query query = manager.createQuery("select a from org.example.nasa.model.Asteroid a");

        return query.getResultList();
    }

    @Override
    public Asteroid findById(int id) {
        return null;
    }

    @Override
    public void save(Asteroid obj) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        try{
            manager.persist(obj);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage() + "FDASFSADASDSA");
        }
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Asteroid obj) {

    }

    @Override
    public void update(Asteroid obj) {

    }
}
