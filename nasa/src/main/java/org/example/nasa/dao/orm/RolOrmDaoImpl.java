package org.example.nasa.dao.orm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.nasa.dao.RolDao;
import org.example.nasa.model.Rol;
import org.example.nasa.model.User;

public class RolOrmDaoImpl implements RolDao {
    EntityManager manager;

    public RolOrmDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("nasa");
        this.manager = emf.createEntityManager();
    }

    @Override
    public Rol getRol(String rol) {
        return manager.find(Rol.class, rol);
    }
}
