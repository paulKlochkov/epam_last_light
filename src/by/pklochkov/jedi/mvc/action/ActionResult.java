package by.pklochkov.jedi.mvc.action;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 26.12.13
 * Time: 3:08
 * To change this template use File | Settings | File Templates.
 */
public class ActionResult implements Map<String, Object>, Serializable {
    private Map<String, Object> modelValues = new HashMap<String, Object>();
    private String viewName;

    public ActionResult() {
    }

    public ActionResult(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public int size() {
        return modelValues.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isEmpty() {
        return modelValues.isEmpty();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        return modelValues.containsKey(key);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean containsValue(Object value) {
        return modelValues.containsKey(value);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object get(Object key) {
        return modelValues.get(key);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object put(String key, Object value) {
        return modelValues.put(key, value);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object remove(Object key) {
        return modelValues.remove(key);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        modelValues.putAll(m);
    }

    @Override
    public void clear() {
        modelValues.clear();
    }

    @Override
    public Set<String> keySet() {
        return modelValues.keySet();
    }

    @Override
    public Collection<Object> values() {
        return modelValues.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return modelValues.entrySet();
    }
}
