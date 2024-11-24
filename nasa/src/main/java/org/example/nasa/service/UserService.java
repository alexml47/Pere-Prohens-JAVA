package org.example.nasa.service;

import org.example.nasa.dao.UserDao;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.dao.orm.UserOrmDaoImpl;
import org.example.nasa.model.User;

public class UserService {
    private UserDao daoImpl;

    public UserService (){
        daoImpl = new UserOrmDaoImpl();
    }

    public User getUser(String name){
        return daoImpl.getUser(name);
    }

    public void saveUser(User user){
        daoImpl.save(user);
    }
}
