package by.pklochkov.jedi.dao;

import by.pklochkov.jedi.pool.FlexiblePool;
import by.pklochkov.jedi.pool.PoolProxy;
import by.pklochkov.jedi.pool.PoolServant;
import com.mysql.jdbc.Driver;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
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

    private static final class ConnectionCreator implements PoolServant<Connection> {
        private String connectionUrl;
        private String userName;
        private String connectionPassword;

        private ConnectionCreator(String connectionUrl, String userName, String connectionPassword) {
            this.connectionUrl = connectionUrl;
            this.userName = userName;
            this.connectionPassword = connectionPassword;
            try {
                DriverManager.registerDriver(new Driver());
            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
            }
        }

        @Override
        public Connection createObject() throws Exception {
            return DriverManager.getConnection(connectionUrl, userName, connectionPassword);
        }

        @Override
        public void dispose(Connection object) throws Exception {
            object.close();
        }
    }

    public MySQLConnectionPool() {
        if (CONNECTION_FLEXIBLE_POOL == null) {
            CONNECTION_FLEXIBLE_POOL = new FlexiblePool<Connection>(new ConnectionCreator(DB_URL, DB_USER, DB_PASSWORD), 1, 10, false);
        }
    }

    public PoolProxy<Connection> getConnection() {
        return CONNECTION_FLEXIBLE_POOL.borrow();
    }

}
