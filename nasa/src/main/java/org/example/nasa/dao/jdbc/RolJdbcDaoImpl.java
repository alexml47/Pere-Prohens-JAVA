package org.example.nasa.dao.jdbc;

import org.example.nasa.config.MySQLConnection;
import org.example.nasa.dao.RolDao;
import org.example.nasa.model.Asteroid;
import org.example.nasa.model.Rol;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RolJdbcDaoImpl implements RolDao {
    Connection conn;

    public RolJdbcDaoImpl() {
        MySQLConnection mysql = MySQLConnection.getInstance();
        this.conn = mysql.getConnection();
    }

    @Override
    public Rol getRol(String rolName) {
        Rol rol = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rol where rol = " + rolName);
            if (rs.next()) {
                rol = getRolFromResult(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rol;
    }

    @Override
    public Rol getRol(int id) {
        Rol rol = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from rol where id = " + id);
            if (rs.next()) {
                rol = getRolFromResult(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rol;
    }

    private Rol getRolFromResult(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String rol = rs.getString("rol");

        return new Rol(id,rol);
    }
}
