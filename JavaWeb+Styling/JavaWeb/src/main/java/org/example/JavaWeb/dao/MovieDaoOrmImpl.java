package org.example.JavaWeb.dao;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.JavaWeb.model.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class MovieDaoOrmImpl implements MovieDao {

    @Override
    public ArrayList<Movie> findAll() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            DBDao db = new DBDaoImpl();
            String query = "select * from movies";
            ResultSet result = db.executeQueryResult(query);

            while (result.next()) {
                Long id = result.getLong("id");
                String title = result.getString("title");
                String description = result.getString("description");
                int year = result.getInt("year");

                Movie movie = new Movie(id, title, description, year);

                movies.add(movie);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
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
