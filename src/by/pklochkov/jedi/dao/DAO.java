package by.pklochkov.jedi.dao;

import by.pklochkov.jedi.pool.PoolProxy;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public abstract class DAO<T, K> {
    private MySQLConnectionPool mySQLConnectionPool = new MySQLConnectionPool();

    public PoolProxy<Connection> getConnection() {
        return mySQLConnectionPool.getConnection();
    }

    public abstract T create(T object);

    public abstract T update(T object);

    public abstract T delete(T object);

    public abstract T getById(K id);
}
