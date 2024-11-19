package org.example.nasa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.nasa.model.Aproach;

import java.util.List;

public class AproachDaoImpl implements AproachDao {
    EntityManager manager;

    public AproachDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        this.manager = emf.createEntityManager();
    }

    @Override
    public List<Aproach> findAll() {
        Query query = manager.createQuery("select a from org.example.nasa.model.Aproach a");

        return query.getResultList();
    }

    @Override
    public Aproach findById(int id) {
        return null;
    }

    @Override
    public void save(Aproach obj) {

    }

    @Override
    public List<Aproach> getApproachesByAsteroidId(Long asteroidId) {
        String query = "SELECT a FROM Aproach a WHERE a.asteroid.id = :asteroidId";
        return manager.createQuery(query, Aproach.class)
                .setParameter("asteroidId", asteroidId)
                .getResultList();
    }
}