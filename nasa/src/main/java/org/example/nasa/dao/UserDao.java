package org.example.nasa.dao;

import org.example.nasa.model.Asteroid;
import org.example.nasa.model.User;

public interface UserDao extends CrudDao<User>{
    boolean userAstronomer(User user);
}
