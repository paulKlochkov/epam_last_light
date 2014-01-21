package by.pklochkov.jedi.mvc;

import by.pklochkov.jedi.dao.MySQLConnectionPool;
import by.pklochkov.jedi.mvc.action.Action;
import by.pklochkov.jedi.mvc.action.ActionParameters;
import by.pklochkov.jedi.mvc.action.ActionResult;
import by.pklochkov.jedi.pool.PoolProxy;

import java.sql.Connection;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 13.01.14
 * Time: 14:15
 * To change this template use File | Settings | File Templates.
 */
public class HomeAction extends Action {

    public HomeAction(String[] requestPath, String requestMethod) {
        super(requestPath, requestMethod);
    }

    @Override
    public ActionResult execute(ActionParameters actionParameters) throws Exception {
        ActionResult actionResult = new ActionResult("index");
        Long[] nums = new Long[200];
        nums[0] = System.currentTimeMillis();
        for (int i = 1; i < 200; i++) {
            nums[i] = (31 >> (i ^ (1 + i))) & nums[i - 1];
        }
        List l;
        l.iterator();
        PoolProxy<Connection> connection = MySQLConnectionPool.getConnection();
        actionResult.put("nums", nums);
        return actionResult;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
