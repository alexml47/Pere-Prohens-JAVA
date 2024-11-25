package org.example.nasa.dao.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import org.example.nasa.config.MySQLHibernate;
import org.example.nasa.dao.RolDao;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;

public class RolOrmDaoImpl implements RolDao {
    EntityManager manager;

    public RolOrmDaoImpl() {
        MySQLHibernate mysql = new MySQLHibernate();
        manager = mysql.getConnection();
    }

    public Rol getRol(int id) {
        String query = "SELECT a FROM Rol a WHERE a.id = :id";
        try {
            return manager.createQuery(query, Rol.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Rol getRol(String rol) {
        String query = "SELECT a FROM Rol a WHERE a.rol = :rol";
        try {
            return manager.createQuery(query, Rol.class)
                    .setParameter("rol", rol)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
