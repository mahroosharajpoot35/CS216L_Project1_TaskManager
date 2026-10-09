package TaskManager;

public class TaskLinkedList {

    TaskNode head;

    // Add task
    void add(Task task) {

        TaskNode newNode = new TaskNode(task);

        if (head == null) {
            head = newNode;
        } else {

            TaskNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Display tasks
    void display() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        TaskNode temp = head;

        while (temp != null) {
            temp.task.display();
            temp = temp.next;
        }
    }

    // Search task by ID
    Task search(int id) {

        TaskNode temp = head;

        while (temp != null) {

            if (temp.task.id == id) {
                return temp.task;
            }

            temp = temp.next;
        }

        return null;
    }

    // Delete task
    Task delete(int id) {

        if (head == null) {
            return null;
        }

        if (head.task.id == id) {

            Task deleted = head.task;
            head = head.next;

            return deleted;
        }

        TaskNode temp = head;

        while (temp.next != null) {

            if (temp.next.task.id == id) {

                Task deleted = temp.next.task;

                temp.next = temp.next.next;

                return deleted;
            }

            temp = temp.next;
        }

        return null;
    }

    // Bubble Sort by priority
    void sort() {

        if (head == null) {
            return;
        }

        TaskNode i = head;

        while (i != null) {

            TaskNode j = i.next;

            while (j != null) {

                if (i.task.priority > j.task.priority) {

                    Task temp = i.task;
                    i.task = j.task;
                    j.task = temp;
                }

                j = j.next;
            }

            i = i.next;
        }
    }
}