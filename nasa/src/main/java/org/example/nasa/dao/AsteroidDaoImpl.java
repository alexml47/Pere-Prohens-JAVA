package org.example.nasa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
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
        Query query = manager.createQuery("select a from org.example.nasa.model.Asteroid a");

        return query.getResultList();
    }

    @Override
    public Asteroid findById(int id) {
        return manager.find(Asteroid.class, id);
    }

    @Override
    public void save(Asteroid obj) {
        manager.getTransaction().begin();
        try{
            manager.persist(obj);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        manager.getTransaction().commit();
    }

    @Override
    public void delete(Asteroid obj) {
        manager.getTransaction().begin();
        if (obj.getAprochments() != null) {
            obj.getAprochments().removeAll(obj.getAprochments());
        }
        manager.remove(obj);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Asteroid oldObj,Asteroid newObj) {
        try{
            manager.getTransaction().begin();

            oldObj.setId(newObj.getId());
            oldObj.setAprochments(newObj.getAprochments());
            oldObj.setName(newObj.getName());
            oldObj.setDiameter(newObj.getDiameter());
            oldObj.setMagnitude(newObj.getMagnitude());
            manager.merge(oldObj);
            manager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }
}
