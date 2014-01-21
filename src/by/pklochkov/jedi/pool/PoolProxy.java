package by.pklochkov.jedi.pool;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 18:32
 * To change this template use File | Settings | File Templates.
 */
public abstract class PoolProxy<T> implements AutoCloseable {
    private T instance;
    private Pool<T> ownerPool;

    protected PoolProxy(T instance, Pool<T> ownerPool) {
        this.instance = instance;
        this.ownerPool = ownerPool;
    }

    public T getInstance() {
        return instance;
    }

    @Override
    public void close() {
        ownerPool.release(this);
    }
}
