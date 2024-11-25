package org.example.nasa.dao.orm;

import jakarta.persistence.*;
import org.example.nasa.config.MySQLHibernate;
import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.dao.UserDao;
import org.example.nasa.model.Asteroid;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;

import java.util.List;
import java.util.Objects;

public class UserOrmDaoImpl implements UserDao {
    EntityManager manager;

    public UserOrmDaoImpl() {
        MySQLHibernate mysql = new MySQLHibernate();
        manager = mysql.getConnection();
    }

    @Override
    public User getUser(String name) {
        try {
            String query = "SELECT u FROM User u WHERE u.name = :name";
            return manager.createQuery(query, User.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        try{
            manager.getTransaction().begin();
            Rol managedRol = manager.merge(user.getRol());
            user.setRol(managedRol);
            manager.persist(user);
            manager.getTransaction().commit();
        } catch (RollbackException e){
            throw new RuntimeException(e);
        }
    }
}
