package org.example.nasa.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.example.nasa.dao.*;
import org.example.nasa.dao.orm.AproachDaoImpl;
import org.example.nasa.dao.orm.AsteroidDaoImpl;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;
import org.example.nasa.service.AsteroidApiService;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NasaService{
    AproachDao aproachDao = new AproachDaoImpl();
    AsteroidDao asteroidDao = new AsteroidDaoImpl();

    public List<Asteroid> findAllAsteroids(){
        return asteroidDao.findAll();
    }

    public List<Aproach> findAllAproachesByAsteroidId(Long id){
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
