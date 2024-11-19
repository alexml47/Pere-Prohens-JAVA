package org.example.nasa.dao;

import jakarta.persistence.*;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;

import java.util.List;

public class AproachDaoImpl implements AproachDao {
    EntityManager manager;

    public AproachDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        this.manager = emf.createEntityManager();
    }

    @Override
    public List<Aproach> findAll() {
        return manager.createQuery("select a from org.example.nasa.model.Aproach a", Aproach.class).getResultList();
    }

    @Override
    public Aproach findById(int id) {
        return manager.find(Aproach.class, id);
    }

    @Override
    public void save(Aproach obj) {
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } catch (RollbackException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aproach> getApproachesByAsteroidId(Long asteroidId) {
        String query = "SELECT a FROM Aproach a WHERE a.asteroid.id = :asteroidId";
        return manager.createQuery(query, Aproach.class)
                .setParameter("asteroidId", asteroidId)
                .getResultList();
    }
}