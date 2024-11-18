package org.example.nasa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.example.nasa.model.Aproach;

import java.util.List;

public class AproachDaoImpl implements AproachDao {
    @Override
    public List<Aproach> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("select a from org.example.nasa.model.Aproach a");

        return query.getResultList();
    }

    @Override
    public Aproach findById(int id) {
        return null;
    }

    @Override
    public void save(Aproach obj) {

    }
}
