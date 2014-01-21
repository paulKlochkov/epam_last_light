package by.pklochkov.jedi.pool;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 15.01.14
 * Time: 23:30
 * To change this template use File | Settings | File Templates.
 */
public interface PoolServant<T> {
    public T createObject() throws Exception;

    public void dispose(Connection object) throws Exception;

}
