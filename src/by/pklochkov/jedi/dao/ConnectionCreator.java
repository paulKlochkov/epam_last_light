package by.pklochkov.jedi.dao;

import by.pklochkov.jedi.pool.PoolServant;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 19:12
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionCreator implements PoolServant<Connection> {
    private String userName;
    private String password;
    private String host;
    private static final Logger LOGGER = Logger.getLogger(ConnectionCreator.class);

    public ConnectionCreator(String userName, String password, String host, Class<? extends Driver> connectionDriver) throws IllegalAccessException, SQLException, InstantiationException {
        this.userName = userName;
        this.password = password;
        this.host = host;
        try {
            DriverManager.registerDriver(connectionDriver.newInstance());
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Connection createObject() throws SQLException {
        return DriverManager.getConnection(host, userName, password);
    }

    @Override
    public void dispose(Connection object) throws SQLException {
        object.close();
    }
}
