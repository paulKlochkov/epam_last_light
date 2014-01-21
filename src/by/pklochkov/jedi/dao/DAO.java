package by.pklochkov.jedi.dao;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 19:46
 * To change this template use File | Settings | File Templates.
 */
public interface DAO<T, K> {
    T create(T object);

    T update(T object);

    T delete(T object);

    T getById(K id);
}
