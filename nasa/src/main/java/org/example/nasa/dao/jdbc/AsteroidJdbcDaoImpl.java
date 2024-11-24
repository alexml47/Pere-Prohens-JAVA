package org.example.nasa.dao.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.model.Asteroid;

import java.util.List;

public class AsteroidJdbcDaoImpl implements AsteroidDao {

    public AsteroidJdbcDaoImpl() {
    }

    @Override
    public List<Asteroid> findAll() {
    }

    @Override
    public Asteroid findById(int id) {
    }

    @Override
    public void save(Asteroid obj) {
    }

    @Override
    public void delete(Asteroid obj) {
    }


    @Override
    public void update(Asteroid obj) {

    }
}
