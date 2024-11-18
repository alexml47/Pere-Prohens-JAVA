package org.example.nasa.dao;

import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;

public interface AsteroidDao extends GeneralDao<Asteroid> {

    void delete(Asteroid obj);

    void update(Asteroid obj);
}
