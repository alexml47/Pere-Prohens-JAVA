package org.example.nasa.factory;

import jakarta.servlet.http.HttpServletRequest;
import org.example.nasa.service.AproachService;
import org.example.nasa.service.AsteroidService;
import org.example.nasa.service.RolService;
import org.example.nasa.service.UserService;
import org.example.nasa.utils.Session;

public abstract class ServiceFactory {
    public abstract AproachService createAproachService();
    public abstract AsteroidService createAsteroidService();
    public abstract RolService createRolService();
    public abstract UserService createUserService();

    public static ServiceFactory implementation(String implementation) {
        switch(implementation){
            case "JDBC":
                return new ServiceJdbcFactory();
            default:
                return new ServiceOrmFactory();
        }
    }
}
