package by.pklochkov.jedi.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 19:27
 * To change this template use File | Settings | File Templates.
 */
public class Client extends User {
    private List<Project> projects;

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
