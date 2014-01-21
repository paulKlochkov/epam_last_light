package by.pklochkov.jedi.pool;

import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 16.01.14
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 */
public class FlexiblePool<T> extends Pool<T> {
    private static final Logger LOGGER = Logger.getLogger(FlexiblePool.class);
    private List<PoolProxyInstance<T>> poolProxyInstances;
    private PoolServant<T> poolServant;
    private int minSize;
    private int maxSize;

    private PoolProxyInstance<T> getFirstAvailableInstance() {
        PoolProxyInstance<T> borrowingObject = null;
        for (PoolProxyInstance<T> proxyInstance : poolProxyInstances) {
            if (!proxyInstance.isInUse()) {
                borrowingObject = proxyInstance;
                break;
            }
        }
        return borrowingObject;
    }

    public FlexiblePool(PoolServant<T> poolServant, int minSize, int maxSize, boolean lazyInitialization) {
        if (minSize < 0 || maxSize < minSize || poolServant == null) {
            throw new IllegalArgumentException();
        }
        this.poolServant = poolServant;
        this.minSize = minSize;
        this.maxSize = maxSize;
        if (!lazyInitialization) {
            try {
                for (int i = 0; i < minSize; i++) {
                    poolProxyInstances.add(new PoolProxyInstance<T>(poolServant.createObject(), this));
                }
            } catch (Exception exc) {
                LOGGER.error(exc);
            }
        }
    }

    @Override
    public PoolProxy<T> borrow() {
        PoolProxyInstance<T> borrowingObject = getFirstAvailableInstance();
        try {
            if (borrowingObject == null && getPoolSize() < maxSize) {
                borrowingObject = new PoolProxyInstance<T>(poolServant.createObject(), this);
                poolProxyInstances.add(borrowingObject);
            }
            borrowingObject.setInUse(true);
        } catch (Exception exc) {
            LOGGER.error(exc.getMessage());
        }
        return borrowingObject;
    }

    @Override
    public void release(PoolProxy<T> borrowed) {
        try {
            ((PoolProxyInstance<T>) borrowed).setInUse(false);
        } catch (ClassCastException exc) {
            LOGGER.error(exc.getMessage());
        }
    }

    @Override
    public int getPoolSize() {
        return poolProxyInstances.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getActiveObjectsCount() {
        int numberOfActiveObjects = 0;
        for (PoolProxyInstance<T> proxyInstance : poolProxyInstances) {
            if (proxyInstance.isInUse()) {
                numberOfActiveObjects++;
            }
        }
        return numberOfActiveObjects;  //To change body of implemented methods use File | Settings | File Templates.
    }


    public void setServant(PoolServant<T> poolServant) {
        this.poolServant = poolServant;
    }
}
