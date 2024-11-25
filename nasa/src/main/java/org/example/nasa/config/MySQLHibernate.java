package org.example.nasa.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLHibernate {
    private EntityManager manager;
    private static MySQLHibernate instance;

    public MySQLHibernate(){
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
            manager = emf.createEntityManager();
            if(manager != null){
                System.out.println("Connected to MySQL");
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static MySQLHibernate getInstance(){
        if(instance==null){
            instance = new MySQLHibernate();
        }
        return instance;
    }
    public EntityManager getConnection(){
        if(manager != null){
            return this.manager;
        } else {
            return null;
        }
    }
}
