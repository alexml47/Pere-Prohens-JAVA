package org.example.nasa.dao.jdbc;

import jakarta.persistence.NoResultException;
import org.example.nasa.config.MySQLConnection;
import org.example.nasa.dao.RolDao;
import org.example.nasa.dao.UserDao;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserJdbcDaoImpl implements UserDao {
    Connection conn;

    public UserJdbcDaoImpl() {
        MySQLConnection mysql = MySQLConnection.getInstance();
        this.conn = mysql.getConnection();
    }

    @Override
    public User getUser(String name) {
        User user = null;
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where name = " + name);
            if (rs.next()) {
                user = getUserFromResult(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public void save(User user) {
        String query = "insert into user (`name`, `password`,`id_rol`) " +
                "VALUES ("
                + "'" + user.getName() + "'" + ","
                + "'" + user.getPassword() + "'" + ","
                + "'" + user.getRol() + "'" +")";
        try {
            Statement stmt = this.conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUserFromResult(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String password = rs.getString("password");

        RolDao rolDao = new RolJdbcDaoImpl();
        Rol rol = rolDao.getRol(rs.getInt("id"));

        return new User(id,password,name,rol);
    }
}
