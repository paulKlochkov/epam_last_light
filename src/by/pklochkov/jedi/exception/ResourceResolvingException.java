package by.pklochkov.jedi.exception;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 14.01.14
 * Time: 1:09
 * To change this template use File | Settings | File Templates.
 */
public class ResourceResolvingException extends Exception {
    public ResourceResolvingException() {
    }

    public ResourceResolvingException(String message) {
        super(message);
    }

    public ResourceResolvingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceResolvingException(Throwable cause) {
        super(cause);
    }

    public ResourceResolvingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
