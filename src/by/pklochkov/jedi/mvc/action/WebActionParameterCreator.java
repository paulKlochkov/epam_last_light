package by.pklochkov.jedi.mvc.action;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 09.01.14
 * Time: 23:12
 * To change this template use File | Settings | File Templates.
 */
public class WebActionParameterCreator implements ActionParametersCreator {
    @Override
    public ActionParameters createParameters(Object request) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        Map<String, Object> params = new HashMap<String, Object>();
        Enumeration<String> requestParameterNames = ((HttpServletRequest) request).getParameterNames();
        while (requestParameterNames.hasMoreElements()) {
            String paramName = requestParameterNames.nextElement();
            params.put(paramName, servletRequest.getParameter(paramName));
        }
        return new WebActionParameter(servletRequest.getRequestURI(), servletRequest.getMethod(), params);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
