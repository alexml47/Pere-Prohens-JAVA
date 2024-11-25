package org.example.nasa.dao.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import org.example.nasa.config.MySQLConnection;
import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.model.Aproach;
import org.example.nasa.model.Asteroid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AsteroidJdbcDaoImpl implements AsteroidDao {
    Connection conn;

    public AsteroidJdbcDaoImpl() {
        MySQLConnection mysql = MySQLConnection.getInstance();
        this.conn = mysql.getConnection();
    }

    @Override
    public List<Asteroid> findAll() {
        List<Asteroid> asteroids = new ArrayList<Asteroid>();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from asteroid");

            while (rs.next()) {
                Asteroid asteroid = getAsteroidFromResult(rs);
                asteroids.add(asteroid);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return asteroids;
    }

    @Override
    public Asteroid findById(int id) {
        Asteroid asteroid = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from asteroid where id = " + id);
            if (rs.next()) {
                asteroid = getAsteroidFromResult(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return asteroid;
    }

    @Override
    public void save(Asteroid obj) {
        int dangerous = 0;
        int nasaAsteroid = 0;
        if (obj.isDangerous()){
            dangerous = 1;
        }
        if (obj.isNasaAsteroid()){
            nasaAsteroid = 1;
        }
        String query = "insert into asteroid (`name`, `magnitude`,`diameter`,`dangerous`,`nasaAsteroid`) " +
                "VALUES ("
                + "'" + obj.getName() + "'" + ","
                + "'" + obj.getMagnitude() + "'" + ","
                + "'" + obj.getDiameter() + "'" + ","
                + "'" + dangerous + "'" + ","
                + "'" + nasaAsteroid + "'" + ")";
        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Asteroid obj) {
        String query = "DELETE FROM `asteroid` WHERE id = " + obj.getId();
        String query2 = "DELETE FROM `aproach` WHERE `id_asteroid` = " + obj.getId();
        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(query2);
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update(Asteroid obj) {
        int dangerous = 0;
        if (obj.isDangerous()){
            dangerous = 1;
        }
        String query = "UPDATE `asteroid` " +
                "SET `name`=" + "'" + obj.getName() + "'" +
                ",`magnitude`=" + "'" + obj.getMagnitude() + "'" +
                ",`diameter`=" + "'" + obj.getDiameter() + "'" +
                ",`dangerous`=" + "'" + dangerous + "'" +
                "WHERE id = " + obj.getId();
        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Asteroid getAsteroidFromResult(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        double magnitude = rs.getDouble("magnitude");
        double diameter = rs.getDouble("diameter");
        boolean dangerous = rs.getBoolean("dangerous");
        boolean nasaAsteroid = rs.getBoolean("nasaAsteroid");

        return new Asteroid(id,name,magnitude,diameter,dangerous,nasaAsteroid);
    }
}
