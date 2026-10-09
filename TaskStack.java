package TaskManager;

public class TaskStack {

    Task[] stack = new Task[50];
    int top = -1;

    // Push
    void push(Task task) {

        if (top == 49) {
            System.out.println("Stack is full.");
        } else {
            top++;
            stack[top] = task;
        }
    }

    // Pop
    Task pop() {

        if (top == -1) {
            return null;
        }

        Task task = stack[top];
        top--;

        return task;
    }

    // Peek
    Task peek() {

        if (top == -1) {
            return null;
        }

        return stack[top];
    }

    // Is Empty
    boolean isEmpty() {

        return top == -1;
    }

    // Display Stack
    void display() {

        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("Task: " + stack[i].name);
        }
    }
}