package org.example.JavaWeb.dao;

import java.sql.*;

public class DBDaoImpl implements DBDao {

    private Statement createConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://db:3306/movies","root","root");
            return con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("error connecting to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void executeQuery(String query) {
        Statement stmt = createConnection();
        try {
            stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResultSet executeQueryResult(String query) {
        Statement stmt = createConnection();
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
