package by.pklochkov.jedi.mvc.ui;

import by.pklochkov.jedi.exception.ResourceResolvingException;
import by.pklochkov.jedi.mvc.action.ActionParameters;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 13.01.14
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class InternalResourceResolver implements ResourceResolver<OutputStream> {
    private final int DEFAULT_PART_SIZE = 10240;
    private String realResourcePath;
    private String applicationPattern;

    public InternalResourceResolver(String realResourcePath, String applicationPattern) {
        this.realResourcePath = realResourcePath;
        this.applicationPattern = applicationPattern;
    }

    public InternalResourceResolver(String realResourcePath) {
        this.realResourcePath = realResourcePath;
    }

    @Override
    public boolean isResourceRequest(ActionParameters request) {
        return request.getRequestPath().contains(realResourcePath);
    }

    @Override
    public String resolveResourcePath(String requestedPath) {
        String path = applicationPattern != null ?
                requestedPath.replace(applicationPattern, realResourcePath) : realResourcePath + requestedPath;
        return path;
    }

    @Override
    public void forwardToResource(ServletContext context, String resourceKey, OutputStream recipientObject) throws ResourceResolvingException {
        try {
            String resourcePath = resolveResourcePath(resourceKey);
            InputStream resourceStream = context.getResourceAsStream(resourcePath);
            if (resourceStream != null) {
                while (resourceStream.available() > 0) {
                    int available = resourceStream.available();
                    int size = available > DEFAULT_PART_SIZE ? DEFAULT_PART_SIZE : available;
                    byte[] buffer = new byte[size];
                    resourceStream.read(buffer);
                    recipientObject.write(buffer);
                }
            }
        } catch (Exception exc) {
            throw new ResourceResolvingException(exc);
        }

    }
}
