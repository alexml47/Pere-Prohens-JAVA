package org.example.nasa.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
    private Connection connection;
    private static MySQLConnection instance;

    public MySQLConnection(){
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection("jdbc:mysql://db:3306/nasa","root","root");
            if(connection != null){
                System.out.println("Connected to MySQL");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static MySQLConnection getInstance(){
        if(instance==null){
            instance = new MySQLConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        if(connection != null){
            return this.connection;
        } else {
            return null;
        }
    }
}
