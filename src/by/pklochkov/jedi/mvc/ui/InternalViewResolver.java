package by.pklochkov.jedi.mvc.ui;

import by.pklochkov.jedi.mvc.action.ActionResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 07.01.14
 * Time: 2:28
 * To change this template use File | Settings | File Templates.
 */
public class InternalViewResolver implements ServletViewManager {
    private String prefix;
    private String postfix;

    public InternalViewResolver(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(ServletRequest request, ActionResult result) {
        request.setAttribute("model", result);
        return request.getRequestDispatcher(prefix + "/" + result.getViewName() + postfix);
    }

}
