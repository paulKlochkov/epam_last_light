package by.pklochkov.jedi.mvc.ui;

import by.pklochkov.jedi.mvc.action.ActionResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 14.01.14
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */
public interface ServletViewManager {
    RequestDispatcher getRequestDispatcher(ServletRequest request, ActionResult result);
}
