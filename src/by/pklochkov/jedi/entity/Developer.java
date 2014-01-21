package by.pklochkov.jedi.entity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pklochkov
 * Date: 21.01.14
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public class Developer extends User {
    private int hourSalary;
    private List<Task> taskList;

    public int getHourSalary() {
        return hourSalary;
    }

    public void setHourSalary(int hourSalary) {
        this.hourSalary = hourSalary;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
