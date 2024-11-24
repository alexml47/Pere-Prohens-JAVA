package org.example.JavaWeb.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DBDao {
    public void executeQuery(String query);
    public ResultSet executeQueryResult(String query);
}
