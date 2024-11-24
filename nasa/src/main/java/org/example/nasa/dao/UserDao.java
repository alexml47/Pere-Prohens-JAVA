package org.example.nasa.dao;

import org.example.nasa.model.Asteroid;
import org.example.nasa.model.User;

public interface UserDao{
    User getUser(String name);
    void save(User user);
}
