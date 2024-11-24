package org.example.nasa.service;

import org.example.nasa.dao.AproachDao;
import org.example.nasa.dao.RolDao;
import org.example.nasa.dao.orm.AproachOrmDaoImpl;
import org.example.nasa.dao.orm.RolOrmDaoImpl;
import org.example.nasa.model.Aproach;

import java.util.List;

public class AproachService {
    private AproachDao daoImpl;

    public AproachService (AproachDao implementation){
        daoImpl = implementation;
    }

    public void saveAproach(Aproach aproach){
        daoImpl.save(aproach);
    }

    public List<Aproach> findAllAproachesByAsteroidId(int id){
        return daoImpl.getApproachesByAsteroidId(id);
    }
}
