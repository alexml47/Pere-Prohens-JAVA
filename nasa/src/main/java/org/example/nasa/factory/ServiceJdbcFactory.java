package org.example.nasa.factory;

import org.example.nasa.dao.jdbc.AproachJdbcDaoImpl;
import org.example.nasa.dao.jdbc.AsteroidJdbcDaoImpl;
import org.example.nasa.dao.orm.AproachOrmDaoImpl;
import org.example.nasa.dao.orm.AsteroidOrmDaoImpl;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
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
        return new RolService(new RolOrmDaoImpl());
    }

    @Override
    public UserService createUserService() {
        return new UserService(new UserOrmDaoImpl());
    }
}
