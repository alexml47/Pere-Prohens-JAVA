package org.example.nasa.dao;

import org.example.nasa.model.Asteroid;
import org.example.nasa.model.User;

public interface UserDao{
    boolean checkUser(String name, String password);
    void save(User user);
    boolean userAstronomer(User user);
}
