package by.pklochkov.jedi.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 19:08
 * To change this template use File | Settings | File Templates.
 */
public class Manager extends User {
    private List<Developer> availableDevelopers;
    private List<Project> projects;

    public List<Developer> getAvailableDevelopers() {
        return availableDevelopers;
    }

    public void setAvailableDevelopers(List<Developer> availableDevelopers) {
        this.availableDevelopers = availableDevelopers;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
