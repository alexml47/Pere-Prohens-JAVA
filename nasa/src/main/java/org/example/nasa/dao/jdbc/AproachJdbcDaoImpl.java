package org.example.nasa.dao.jdbc;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.RollbackException;
import org.example.nasa.config.MySQLConnection;
import org.example.nasa.dao.AproachDao;
import org.example.nasa.model.Aproach;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AproachJdbcDaoImpl implements AproachDao {
    Connection conn;

    public AproachJdbcDaoImpl() {
        MySQLConnection mysql = MySQLConnection.getInstance();
        this.conn = mysql.getConnection();
    }

    @Override
    public List<Aproach> findAll() {
        List<Aproach> aproaches = new ArrayList<Aproach>();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from aproach");

            while (rs.next()) {
                Aproach aproach = getAproachFromResult(rs);
                aproaches.add(aproach);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aproaches;
    }

    @Override
    public Aproach findById(int id) {
        Aproach aproach = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from aproach where id = " + id);
            if (rs.next()) {
                aproach = getAproachFromResult(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aproach;
    }

    @Override
    public void save(Aproach obj) {
        String query = "insert into aproach (`aproachDate`, `velocity`, `distance`,`orbitingBody`,`id_asteroid`) " +
                "VALUES ("
                + "'" + obj.getAproachDate() + "'" + ","
                + "'" + obj.getVelocity() + "'" + ","
                + "'" + obj.getDistance() + "'" + ","
                + "'" + obj.getOrbitingBody() + "'" + ","
                + "'" + obj.getAsteroid() + "'" + ")";
        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Aproach> getApproachesByAsteroidId(int asteroidId) {
        List<Aproach> aproaches = new ArrayList<>();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from aproach where id_asteroid = " + asteroidId);

            while (rs.next()) {
                Aproach aproach = getAproachFromResult(rs);
                aproaches.add(aproach);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aproaches;
    }

    private Aproach getAproachFromResult(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        LocalDate aproachDate = rs.getDate("aproachDate").toLocalDate();
        double velocity = rs.getDouble("velocity");
        double distance = rs.getDouble("distance");
        String orbitingBody = rs.getString("orbitingBody");

        return new Aproach(id,aproachDate,velocity,distance,orbitingBody);
    }
}