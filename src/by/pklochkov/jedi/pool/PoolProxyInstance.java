package by.pklochkov.jedi.pool;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 18:38
 * To change this template use File | Settings | File Templates.
 */
class PoolProxyInstance<T> extends PoolProxy<T> {
    private boolean isInUse;

    PoolProxyInstance(T instance, Pool<T> ownerPool) {
        super(instance, ownerPool);
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }
}
