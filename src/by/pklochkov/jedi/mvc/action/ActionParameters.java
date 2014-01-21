package by.pklochkov.jedi.mvc.action;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 05.01.14
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
public interface ActionParameters {
    public String getRequestPath();

    public String getRequestMethod();

    public Object getParameter(String paramName);
}
