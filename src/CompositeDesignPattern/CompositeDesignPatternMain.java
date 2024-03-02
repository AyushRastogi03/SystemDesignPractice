package CompositeDesignPattern;

/*
Structural Design pattern
As described by the Gang of four, “Compose objects into tree structure
 to represent part-whole hierarchies. Composite lets client treat
 individual objects and compositions of objects uniformly”.
 It has 4 parts
 1. Composite class
 2. Leaf Class
 3. Base Class
 4. Client Class
 */

// Client CLass
public class CompositeDesignPatternMain {
    public static void main(String[] args) {
        Task simpleTask = new SimpleTask("Complete Coding");
        Task simpleTask2  = new SimpleTask("Write Documentation");

        TaskList projectTasks = new TaskList("Project Task");
        projectTasks.addTask(simpleTask);
        projectTasks.addTask(simpleTask2);

        TaskList phase1Task = new TaskList("Phase 1 Task");

        phase1Task.addTask(new SimpleTask("Design"));
        phase1Task.addTask(new SimpleTask("Implementation"));

        projectTasks.addTask(phase1Task);
        projectTasks.display();
    }
}
