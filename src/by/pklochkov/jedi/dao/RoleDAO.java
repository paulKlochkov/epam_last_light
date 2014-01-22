package by.pklochkov.jedi.dao;

import by.pklochkov.jedi.entity.Role;
import by.pklochkov.jedi.pool.PoolProxy;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public class RoleDAO extends DAO<Role, Long> {
    private static final Logger LOGGER = Logger.getLogger(RoleDAO.class);

    private static final String INSERT_QUERY = "INSERT INTO roles VALUES(?)";
    private static final String UPDATE_QUERY = "UPDATE roles SET roles.name = ? WHERE roles.id = ?";
    private static final String SELECT_ID_QUERY = "SELECT * FROM roles WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM roles WHERE roles.id = ?";
    private static EntityCreator<Role> roleEntityCreator = new RoleCreator();

    @Override
    public Role create(Role object) {
        try (PoolProxy<Connection> connectionPoolProxy = getConnection()) {
            Connection connection = connectionPoolProxy.getInstance();
            PreparedStatement insertQuery = connection.prepareStatement(INSERT_QUERY, java.sql.Statement.RETURN_GENERATED_KEYS);
            insertQuery.setString(1, object.getRoleName());
            insertQuery.execute();
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage());
        }
        return object;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Role update(Role object) {
        try (PoolProxy<Connection> poolProxyConnection = getConnection()) {
            Connection connection = poolProxyConnection.getInstance();
            PreparedStatement updateQuery = connection.prepareStatement(UPDATE_QUERY);
            updateQuery.setLong(2, object.getId());
            updateQuery.setString(1, object.getRoleName());
            updateQuery.execute();
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage());
        }
        return object;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Role object) {
        try (PoolProxy<Connection> poolProxy = getConnection()) {
            Connection connection = poolProxy.getInstance();
            PreparedStatement deleteQuery = connection.prepareStatement(DELETE_QUERY);
            deleteQuery.setLong(1, object.getId());
            deleteQuery.execute();
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage());
        }
    }

    @Override
    public Role getById(Long id) {
        try (PoolProxy<Connection> poolProxy = getConnection()) {
            Connection connection = poolProxy.getInstance();
            PreparedStatement selectQuery = connection.prepareStatement(SELECT_ID_QUERY);
            selectQuery.setLong(1, id);
            Role role = roleEntityCreator.createEntity(selectQuery.executeQuery());
            return role;
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage());
        }
        return null;
    }
}
