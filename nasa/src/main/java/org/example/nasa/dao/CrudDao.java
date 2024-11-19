package org.example.nasa.dao;

import java.util.List;

public interface CrudDao<T>{
    List<T> findAll();
    T findById(int id);
    void save(T obj);
}
