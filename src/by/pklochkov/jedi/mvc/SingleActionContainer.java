package by.pklochkov.jedi.mvc;

import by.pklochkov.jedi.exception.ControllerNotFoundException;
import by.pklochkov.jedi.mvc.action.Action;
import by.pklochkov.jedi.mvc.action.ActionParameters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 07.01.14
 * Time: 1:19
 * To change this template use File | Settings | File Templates.
 */
public class SingleActionContainer extends ActionContainer {
    private Set<Action> actions = new HashSet<Action>();

    @Override
    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public Action getByRequest(ActionParameters actionParameters) throws ControllerNotFoundException {
        for (Action action : actions) {
            if (getActionMatcher().match(action, actionParameters)) {
                return action;
            }
        }
        throw new ControllerNotFoundException();
    }
}
