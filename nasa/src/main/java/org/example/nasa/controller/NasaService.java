package org.example.nasa.controller;

import org.example.nasa.dao.*;
import org.example.nasa.dao.jdbc.AproachJdbcDaoImpl;
import org.example.nasa.dao.jdbc.AsteroidJdbcDaoImpl;
import org.example.nasa.dao.orm.AproachOrmDaoImpl;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;
import org.example.nasa.service.AsteroidApiService;

import java.util.List;

public class NasaService{
    AproachDao aproachDao = new AproachOrmDaoImpl();
    AsteroidDao asteroidDao = new AsteroidOrmDaoImpl();
    UserDao userDao = new UserOrmDaoImpl();
    RolDao rolDao = new RolOrmDaoImpl();

    public Rol getRol(String rol){
        return rolDao.getRol(rol);
    }

    public void saveUser(User user){
        userDao.save(user);
    }

    public boolean userAstronomer(User user){
        return userDao.userAstronomer(user);
    }

    public List<Asteroid> findAllAsteroids(){
        return asteroidDao.findAll();
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

    public void update(Asteroid obj) {
        asteroidDao.update(obj);
    }

    public void delete(Asteroid asteroid) {
        asteroidDao.delete(asteroid);
    }

    public void synchronize() {
        List <Asteroid> asteroids = findAllAsteroids();
        if (!asteroids.isEmpty()) {
            for (Asteroid asteroid : asteroids) {
                asteroidDao.delete(asteroid);
            }
        }

        AsteroidApiService api = new AsteroidApiService();
        for(Asteroid asteroid : api.getAsteroids()){
            saveAsteroid(asteroid);
        }
    }
}


