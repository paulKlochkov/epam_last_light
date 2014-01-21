package by.pklochkov.jedi.mvc;

import by.pklochkov.jedi.exception.ControllerNotFoundException;
import by.pklochkov.jedi.mvc.action.Action;
import by.pklochkov.jedi.mvc.action.ActionParameters;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 09.01.14
 * Time: 16:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class ActionContainer {
    private ActionMatcher actionMatcher = new RelativeUrlMatcher();

    public abstract void addAction(Action action);

    public abstract Action getByRequest(ActionParameters actionParameters) throws ControllerNotFoundException;

    public void setActionMatcher(ActionMatcher actionMatcher) {
        this.actionMatcher = actionMatcher;
    }

    public ActionMatcher getActionMatcher() {
        return actionMatcher;
    }
}
