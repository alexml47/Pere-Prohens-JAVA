package org.example.nasa.dao;

import org.example.nasa.model.Rol;

public interface RolDao {
    Rol getRol(String rol);
    Rol getRol(int id);
}
