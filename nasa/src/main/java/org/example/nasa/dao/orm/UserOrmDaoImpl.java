package org.example.nasa.dao.orm;

import jakarta.persistence.*;
import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.dao.UserDao;
import org.example.nasa.model.Asteroid;
import org.example.nasa.model.User;

import java.util.List;
import java.util.Objects;

public class UserOrmDaoImpl implements UserDao {
    EntityManager manager;

    public UserOrmDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        this.manager = emf.createEntityManager();
    }

    @Override
    public List<User> findAll() {
        return manager.createQuery("select a from User a", User.class).getResultList();
    }

    @Override
    public User findById(int id) {
        return manager.find(User.class, id);
    }



    @Override
    public void save(User obj) {
        try{
            manager.getTransaction().begin();
            manager.persist(obj);
            manager.getTransaction().commit();
        } catch (RollbackException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean userAstronomer(User user) {
        return Objects.equals(user.getRol().getName(), "astronomer");
    }
}