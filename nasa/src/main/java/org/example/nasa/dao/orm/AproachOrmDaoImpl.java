package org.example.nasa.dao.orm;

import jakarta.persistence.*;
import org.example.nasa.config.MySQLHibernate;
import org.example.nasa.dao.AproachDao;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;
import org.example.nasa.model.Rol;

import java.util.List;

public class AproachOrmDaoImpl implements AproachDao {
    EntityManager manager;

    public AproachOrmDaoImpl() {
        MySQLHibernate mysql = new MySQLHibernate();
        manager = mysql.getConnection();
    }

    @Override
    public List<Aproach> findAll() {
        return manager.createQuery("select a from Aproach a", Aproach.class).getResultList();
    }

    @Override
    public Aproach findById(int id) {
        return manager.find(Aproach.class, id);
    }

    @Override
    public void save(Aproach obj) {
        try{
            manager.getTransaction().begin();
            Asteroid managedAsteroid = manager.merge(obj.getAsteroid());
            obj.setAsteroid(managedAsteroid);
            manager.persist(obj);
            manager.getTransaction().commit();
        } catch (RollbackException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aproach> getApproachesByAsteroidId(int asteroidId) {
        String query = "SELECT a FROM Aproach a WHERE a.asteroid.id = :asteroidId";
        return manager.createQuery(query, Aproach.class)
                .setParameter("asteroidId", asteroidId)
                .getResultList();
    }
}