package by.pklochkov.jedi.dao;

import by.pklochkov.jedi.entity.Role;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 22.01.14
 * Time: 18:21
 * To change this template use File | Settings | File Templates.
 */
public class RoleCreator implements EntityCreator<Role> {
    @Override
    public Role createEntity(ResultSet resultSet) {
        Role role = new Role();
        try {
            role.setId(resultSet.getLong(1));
            role.setRoleName(resultSet.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return role;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
