package org.example.nasa.service;

import org.example.nasa.dao.RolDao;
import org.example.nasa.dao.UserDao;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.model.Rol;

public class RolService {
    private RolDao daoImpl;

    public RolService (RolDao implementation){
        daoImpl = implementation;
    }

    public Rol getRol(String rol){
        return daoImpl.getRol(rol);
    }
}
