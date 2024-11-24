package org.example.nasa.service;

import org.example.nasa.model.Asteroid;

public class ServiceFactory {
    public static AproachService createAproachService() {
        return new AproachService();
    }
    public static AsteroidService createAsteroidService() {
        return new AsteroidService();
    }
    public static RolService createRolService() {
        return new RolService();
    }
    public static UserService createUserService() {
        return new UserService();
    }
}
