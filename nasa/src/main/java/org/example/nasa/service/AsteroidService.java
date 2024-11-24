package org.example.nasa.service;

import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.dao.RolDao;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.model.Asteroid;
import org.example.nasa.utils.AsteroidJsonConvertor;

import java.util.List;

public class AsteroidService {
    private AsteroidDao daoImpl;

    public AsteroidService (AsteroidDao implementation){
        daoImpl = implementation;
    }

    public List<Asteroid> findAllAsteroids(){
        return daoImpl.findAll();
    }

    public void saveAsteroid(Asteroid asteroid){
        daoImpl.save(asteroid);
    }

    public Asteroid findAsteroid(int id){
        return daoImpl.findById(id);
    }

    public void updateAsteroid(Asteroid obj) {
        daoImpl.update(obj);
    }

    public void deleteAsteroid(Asteroid asteroid) {
        daoImpl.delete(asteroid);
    }

    public void synchronize() {
        List <Asteroid> asteroids = findAllAsteroids();
        if (!asteroids.isEmpty()) {
            for (Asteroid asteroid : asteroids) {
                if (asteroid.isNasaAsteroid()){
                    daoImpl.delete(asteroid);
                }
            }
        }
        AsteroidJsonConvertor api = new AsteroidJsonConvertor();
        for(Asteroid asteroid : api.getAsteroids()){
            saveAsteroid(asteroid);
        }
    }
}
