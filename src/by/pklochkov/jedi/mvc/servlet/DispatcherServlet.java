package by.pklochkov.jedi.mvc.servlet;

import by.pklochkov.jedi.mvc.*;
import by.pklochkov.jedi.mvc.action.ActionParameters;
import by.pklochkov.jedi.mvc.action.ActionParametersCreator;
import by.pklochkov.jedi.mvc.action.ActionResult;
import by.pklochkov.jedi.mvc.action.WebActionParameterCreator;
import by.pklochkov.jedi.mvc.ui.InternalResourceResolver;
import by.pklochkov.jedi.mvc.ui.InternalViewResolver;
import by.pklochkov.jedi.mvc.ui.ServletViewManager;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 26.12.13
 * Time: 3:04
 * To change this template use File | Settings | File Templates.
 */
public class DispatcherServlet extends javax.servlet.http.HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(DispatcherServlet.class);
    private ServletViewManager servletViewManager = new InternalViewResolver("/resource/view", ".jsp");
    private ActionParametersCreator actionParametersCreator = new WebActionParameterCreator();
    private ActionContainer actionContainer = new SingleActionContainer();
    private InternalResourceResolver internalResourceResolver = new InternalResourceResolver("resource/", "resource/");

    {
        actionContainer.addAction(new HomeAction(new String[]{"/", "/home"}, "GET"));
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            ActionParameters actionParameters = actionParametersCreator.createParameters(request);
            if (!internalResourceResolver.isResourceRequest(actionParameters)) {
                ActionResult ar = actionContainer.getByRequest(actionParameters).execute(actionParameters);
                servletViewManager.getRequestDispatcher(request, ar).forward(request, response);
            } else {
                internalResourceResolver.forwardToResource(getServletContext(), request.getRequestURI(), response.getOutputStream());
            }
        } catch (Exception exc) {
            LOGGER.error(request.getRequestURI() + exc.getLocalizedMessage());
        }

    }
}
