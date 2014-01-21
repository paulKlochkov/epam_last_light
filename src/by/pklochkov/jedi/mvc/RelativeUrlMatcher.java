package by.pklochkov.jedi.mvc;

import by.pklochkov.jedi.mvc.action.Action;
import by.pklochkov.jedi.mvc.action.ActionParameters;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 13.01.14
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class RelativeUrlMatcher implements ActionMatcher {
    @Override
    public boolean match(Action action, ActionParameters actionUri) {
        for (String path : action.getRequestPath()) {
            if (((actionUri.getRequestPath().endsWith(path) && !path.isEmpty()) || actionUri.getRequestPath().equals(path)) && action.getRequestMethod().equals(actionUri.getRequestMethod())) {
                return true;
            }

        }
        return false;
    }
}
