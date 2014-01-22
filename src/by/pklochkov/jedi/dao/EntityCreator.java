package by.pklochkov.jedi.dao;

import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 22.01.14
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
public interface EntityCreator<T> {
    T createEntity(ResultSet resultSet);
}
