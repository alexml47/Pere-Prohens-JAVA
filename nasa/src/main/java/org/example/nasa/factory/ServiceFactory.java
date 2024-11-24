package org.example.nasa.factory;

import jakarta.servlet.http.HttpServletRequest;
import org.example.nasa.dao.AproachDao;
import org.example.nasa.dao.AsteroidDao;
import org.example.nasa.dao.RolDao;
import org.example.nasa.dao.UserDao;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.service.AproachService;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.service.RolService;
import org.example.nasa.service.UserService;
import org.example.nasa.utils.Session;

import java.net.http.HttpRequest;

public abstract class ServiceFactory {
    public abstract AproachService createAproachService();
    public abstract AsteroidService createAsteroidService();
    public abstract RolService createRolService();
    public abstract UserService createUserService();

    public static ServiceFactory implementation(HttpServletRequest req){
        String implementation = Session.getAttribute(req,"implementation");
        if (implementation == null){
            implementation = "ORM";
        }
        switch(implementation){
            case "JDBC":
                return new ServiceJdbcFactory();
            default:
                return new ServiceOrmFactory();
        }
    }
}
