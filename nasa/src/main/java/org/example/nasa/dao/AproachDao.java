package org.example.nasa.dao;

import org.example.nasa.model.Aproach;

import java.util.List;

public interface AproachDao extends CrudDao<Aproach> {

    List<Aproach> getApproachesByAsteroidId(int asteroidId);
}
