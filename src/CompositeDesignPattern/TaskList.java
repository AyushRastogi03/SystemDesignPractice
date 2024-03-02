package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;


//composite class
public class TaskList implements Task{

    private String title;
    private List<Task> taskList;

    public TaskList(String title) {
        this.title = title;
        this.taskList = new ArrayList<>();
    }


    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
       this.title = title;
    }

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void removeTask(Task task) {
        taskList.remove(task);
    }

    @Override
    public void display() {
        System.out.println("Task List : " + title);
        taskList.forEach(task -> task.display());
    }
}
