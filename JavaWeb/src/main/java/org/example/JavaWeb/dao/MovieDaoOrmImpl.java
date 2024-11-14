package org.example.JavaWeb.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import org.example.JavaWeb.model.Movie;
import jakarta.persistence.Persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@ApplicationScoped
public class MovieDaoOrmImpl implements MovieDao {

    @Override
    public ArrayList<Movie> findAll(){

        EntityManager em = ConnectionManager.getEntityManager();
    }

    @Override
    public Movie findById(Long id) {
        Movie movie = null;
        DBDao db = new DBDaoImpl();
        ResultSet rs = db.executeQueryResult("select * from movies where id = " + id);
        try{
            rs.next();
            String title = rs.getString("title");
            String description = rs.getString("description");
            int year = rs.getInt("year");
            movie = new Movie(id,title,description,year);

        } catch (SQLException e) {
            System.out.println("error sql");
        }

        return movie;

    }

    @Override
    public void save(Movie movie) {
        DBDao db = new DBDaoImpl();
        String query = "insert into movies (`title`, `description`, `year`) " +
                "VALUES ("
                + "'" + movie.getTitle() + "'" + ","
                + "'" + movie.getDescription() + "'" + ","
                + "'" + movie.getYear() + "'" + ")";
        db.executeQuery(query);
    }

    @Override
    public void update(Movie movie) {
        DBDao db = new DBDaoImpl();
        String query = "UPDATE `movies` " +
                "SET `title`=" + "'" + movie.getTitle() + "'" +
                ",`description`=" + "'" + movie.getDescription() + "'" +
                ",`year`=" + "'" + movie.getYear() + "'" +
                "WHERE id = " + movie.getId();
        db.executeQuery(query);
    }

    @Override
    public void delete(int id) {
        DBDao db = new DBDaoImpl();
        String query = "delete from `movies` WHERE id = " + id;
        db.executeQuery(query);
    }

}
