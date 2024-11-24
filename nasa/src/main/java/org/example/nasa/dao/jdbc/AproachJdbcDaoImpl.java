package org.example.nasa.dao.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import org.example.nasa.dao.AproachDao;
import org.example.nasa.model.Aproach;

import java.util.List;

public class AproachJdbcDaoImpl implements AproachDao {

    public AproachJdbcDaoImpl() {
    }

    @Override
    public List<Aproach> findAll() {
    }

    @Override
    public Aproach findById(int id) {
    }

    @Override
    public void save(Aproach obj) {

    }

    @Override
    public List<Aproach> getApproachesByAsteroidId(int asteroidId) {

    }
}