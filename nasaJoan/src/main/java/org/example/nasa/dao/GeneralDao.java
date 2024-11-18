package org.example.nasa.dao;

import java.util.List;

public interface GeneralDao <T>{
    List<T> findAll();
    T findById(int id);
    void save(T obj);
}
