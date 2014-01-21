package by.pklochkov.jedi.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 19:15
 * To change this template use File | Settings | File Templates.
 */
public class Project {
    private Long id;
    private User manager;
    private User owner;
    private List<Task> tasks;

    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
