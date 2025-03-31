package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import com.example.db.ConnectionDB;

public abstract class DAO<T> {
    protected Connection connection;

    public DAO() throws ClassNotFoundException {
        this.connection = ConnectionDB.getInstance();
    }

    public abstract boolean create(T obj) throws SQLException;
    public abstract T read(int id) throws SQLException;
    public abstract boolean update(T obj) throws SQLException;
    public abstract boolean delete(int id) throws SQLException;
}
