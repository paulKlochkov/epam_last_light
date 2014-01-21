package by.pklochkov.jedi.web.filter;

import javax.servlet.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 31.12.13
 * Time: 12:30
 * To change this template use File | Settings | File Templates.
 */
public class SecurityFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        //  req.getRequestDispatcher("/jedi.jsp").forward(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
