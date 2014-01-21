package by.pklochkov.jedi.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class LoginData {
    private Long id;
    private String username;
    private String password;
    private User user;
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
