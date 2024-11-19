package org.example.nasa.dao;

import org.example.nasa.model.Asteroid;

public interface AsteroidDao extends CrudDao<Asteroid> {

    void delete(Asteroid obj);

    void update(Asteroid obj);
}
