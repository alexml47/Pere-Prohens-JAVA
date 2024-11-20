package org.example.nasa.dao.orm;

import jakarta.persistence.*;
import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.model.Asteroid;

import java.util.List;

public class AsteroidDaoImpl implements AsteroidDao {
    EntityManager manager;

    public AsteroidDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        this.manager = emf.createEntityManager();
    }

    @Override
    public List<Asteroid> findAll() {
        return manager.createQuery("select a from Asteroid a", Asteroid.class).getResultList();
    }

    @Override
    public Asteroid findById(int id) {
        return manager.find(Asteroid.class, id);
    }

    @Override
    public void save(Asteroid obj) {
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } catch (RollbackException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Asteroid obj) {
        manager.getTransaction().begin();
        manager.remove(obj);
        manager.getTransaction().commit();
    }


    @Override
    public void update(Asteroid obj) {
        try{
            manager.getTransaction().begin();
            manager.merge(obj);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }


}
