package org.example.nasa.service;

import org.example.nasa.dao.UserDao;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.model.User;

public class UserService {
    private UserDao daoImpl;

    public UserService (UserDao implemenation){
        daoImpl = implemenation;
    }

    public User getUser(String name){
        return daoImpl.getUser(name);
    }

    public void saveUser(User user){
        daoImpl.save(user);
    }
}
