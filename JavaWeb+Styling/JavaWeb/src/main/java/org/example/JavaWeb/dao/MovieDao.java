package org.example.JavaWeb.dao;

import org.example.JavaWeb.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MovieDao {
    ArrayList<Movie> findAll();
    Movie findById(Long id);
    void save(Movie movie);
    void update(Movie movie);
    void delete(int id);
}
