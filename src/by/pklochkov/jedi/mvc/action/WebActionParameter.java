package by.pklochkov.jedi.mvc.action;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 09.01.14
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
class WebActionParameter implements ActionParameters {
    private String localPath;
    private String method;
    private Map<String, Object> params = new HashMap<String, Object>();

    public WebActionParameter(String localPath, String method, Map<String, Object> params) {
        this.localPath = localPath;
        this.method = method;
        this.params = params;
    }

    @Override
    public String getRequestPath() {
        return localPath;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getRequestMethod() {
        return method;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getParameter(String paramName) {
        return params.get(paramName);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
