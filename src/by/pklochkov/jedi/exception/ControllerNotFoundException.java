package by.pklochkov.jedi.exception;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 07.01.14
 * Time: 1:24
 * To change this template use File | Settings | File Templates.
 */
public class ControllerNotFoundException extends Exception {
    public ControllerNotFoundException() {
    }

    public ControllerNotFoundException(String message) {
        super(message);
    }

    public ControllerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerNotFoundException(Throwable cause) {
        super(cause);
    }

    public ControllerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
