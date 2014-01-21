package by.pklochkov.jedi.pool;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
public abstract class Pool<T> {
    public abstract PoolProxy<T> borrow();

    public abstract void release(PoolProxy<T> borrowed);

    public abstract int getPoolSize();

    public abstract int getActiveObjectsCount();

}
