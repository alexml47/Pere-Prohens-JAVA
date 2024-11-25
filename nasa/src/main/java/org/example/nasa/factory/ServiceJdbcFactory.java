package org.example.nasa.factory;

import org.example.nasa.dao.jdbc.AproachJdbcDaoImpl;
import org.example.nasa.dao.jdbc.AsteroidJdbcDaoImpl;
import org.example.nasa.dao.jdbc.RolJdbcDaoImpl;
import org.example.nasa.dao.jdbc.UserJdbcDaoImpl;
import org.example.nasa.service.AproachService;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.service.RolService;
import org.example.nasa.service.UserService;

public class ServiceJdbcFactory extends ServiceFactory{
    @Override
    public AproachService createAproachService() {
        return new AproachService(new AproachJdbcDaoImpl());
    }

    @Override
    public AsteroidService createAsteroidService() {
        return new AsteroidService(new AsteroidJdbcDaoImpl());
    }

    @Override
    public RolService createRolService() {
        return new RolService(new RolJdbcDaoImpl());
    }

    @Override
    public UserService createUserService() {
        return new UserService(new UserJdbcDaoImpl());
    }
}
