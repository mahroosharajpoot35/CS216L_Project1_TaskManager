package TaskManager;

public class Task {

    int id;
    String name;
    int priority;

    Task(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    void display() {
        System.out.println("ID: " + id +
                " | Task: " + name +
                " | Priority: " + priority);
    }
}