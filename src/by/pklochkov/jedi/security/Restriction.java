package by.pklochkov.jedi.security;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 14.01.14
 * Time: 18:52
 * To change this template use File | Settings | File Templates.
 */
public class Restriction {
    private String path;
    private String[] roles;

    public String[] getRoles()     {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
