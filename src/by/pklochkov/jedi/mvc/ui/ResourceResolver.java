package by.pklochkov.jedi.mvc.ui;

import by.pklochkov.jedi.exception.ResourceResolvingException;
import by.pklochkov.jedi.mvc.action.ActionParameters;

import javax.servlet.ServletContext;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 14.01.14
 * Time: 0:30
 * To change this template use File | Settings | File Templates.
 */
public interface ResourceResolver<T> {
    boolean isResourceRequest(ActionParameters request);

    String resolveResourcePath(String requestedPath);

    void forwardToResource(ServletContext context, String resourceKey, T recipientObject) throws ResourceResolvingException;
}
