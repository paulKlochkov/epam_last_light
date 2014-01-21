package by.pklochkov.jedi.entity;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 19:03
 * To change this template use File | Settings | File Templates.
 */
public class Role {
    private Long id;
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
