package by.pklochkov.jedi.dao;

import by.pklochkov.jedi.pool.FlexiblePool;
import by.pklochkov.jedi.pool.PoolProxy;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public class MySQLConnectionPool {
    private static FlexiblePool<Connection> CONNECTION_FLEXIBLE_POOL = null;
    private final static String DB_URL = "jdbc:mysql://localhost/project_db";
    private final static String DB_USER = "root";
    private final static String DB_PASSWORD = "admin";
    private static final Logger LOGGER = Logger.getLogger(MySQLConnectionPool.class);

    static {

    }

    public static PoolProxy<Connection> getConnection() {
        return CONNECTION_FLEXIBLE_POOL.borrow();
    }
}
