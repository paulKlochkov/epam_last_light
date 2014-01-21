package by.pklochkov.jedi.mvc.action;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 26.12.13
 * Time: 3:07
 * To change this template use File | Settings | File Templates.
 */
public abstract class Action {

    private String[] requestPath;
    private String requestMethod;


    public Action(String[] requestPath, String requestMethod) {
        this.requestPath = requestPath;
        this.requestMethod = requestMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action that = (Action) o;

        if (requestMethod != null ? !requestMethod.equals(that.requestMethod) : that.requestMethod != null)
            return false;
        if (requestPath != null ? !requestPath.equals(that.requestPath) : that.requestPath != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = requestPath != null ? requestPath.hashCode() : 0;
        result = 31 * result + (requestMethod != null ? requestMethod.hashCode() : 0);
        return result;
    }

    public String[] getRequestPath() {
        return requestPath;
    }

    public void setRequestPath(String[] requestPath) {
        this.requestPath = requestPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public abstract ActionResult execute(ActionParameters actionParameters) throws Exception;

}
