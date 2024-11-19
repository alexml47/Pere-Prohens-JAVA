package org.example.nasa.dao;

import org.example.nasa.model.Aproach;

import java.util.List;

public interface AproachDao extends GeneralDao<Aproach>{

    public List<Aproach> getApproachesByAsteroidId(Long asteroidId);
}
