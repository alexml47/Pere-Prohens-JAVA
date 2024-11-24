package org.example.nasa.service;

import org.example.nasa.dao.*;
import org.example.nasa.dao.orm.AproachOrmDaoImpl;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;
import org.example.nasa.utils.AsteroidJsonConvertor;

import java.util.List;

public class NasaService{
    AproachDao aproachDao = new AproachOrmDaoImpl();
    AsteroidDao asteroidDao = new AsteroidOrmDaoImpl();
    UserDao userDao = new UserOrmDaoImpl();
    RolDao rolDao = new RolOrmDaoImpl();

    public Rol getRol(String rol){
        return rolDao.getRol(rol);
    }

    public User getUser(String name){
        return userDao.getUser(name);
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public List<Asteroid> findAllAsteroids(){
        return asteroidDao.findAll();
    }

    public void saveAproach(Aproach aproach){
        aproachDao.save(aproach);
    }

    public List<Aproach> findAllAproachesByAsteroidId(int id){
        return aproachDao.getApproachesByAsteroidId(id);
    }

    public void saveAsteroid(Asteroid asteroid){
        asteroidDao.save(asteroid);
    }

    public Asteroid findAsteroid(int id){
        return asteroidDao.findById(id);
    }

    public void updateAsteroid(Asteroid obj) {
        asteroidDao.update(obj);
    }

    public void deleteAsteroid(Asteroid asteroid) {
        asteroidDao.delete(asteroid);
    }

    public void synchronize() {
        List <Asteroid> asteroids = findAllAsteroids();
        if (!asteroids.isEmpty()) {
            for (Asteroid asteroid : asteroids) {
                if (asteroid.isNasaAsteroid()){
                    asteroidDao.delete(asteroid);
                }
            }
        }

        AsteroidJsonConvertor api = new AsteroidJsonConvertor();
        for(Asteroid asteroid : api.getAsteroids()){
            saveAsteroid(asteroid);
        }
    }
}


