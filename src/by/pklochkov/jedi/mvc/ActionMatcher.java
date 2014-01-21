package by.pklochkov.jedi.mvc;

import by.pklochkov.jedi.mvc.action.Action;
import by.pklochkov.jedi.mvc.action.ActionParameters;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 13.01.14
 * Time: 0:39
 * To change this template use File | Settings | File Templates.
 */
public interface ActionMatcher {
    boolean match(Action action, ActionParameters actionUri);
}
