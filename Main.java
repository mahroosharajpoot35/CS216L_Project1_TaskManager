package TaskManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TaskLinkedList list = new TaskLinkedList();
        TaskStack stack = new TaskStack();

        int choice;

        do {

            System.out.println("\n===== TASK MANAGER =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Sort Tasks");
            System.out.println("5. Delete Task");
            System.out.println("6. Undo Delete");
            System.out.println("7. View Stack");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Please enter a number.");
                input.next();
                System.out.print("Enter choice: ");
            }

            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Task ID: ");
                    int id = input.nextInt();

                    if (list.search(id) != null) {
                        System.out.println("ID already exists.");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Priority (1=High, 2=Medium, 3=Low): ");
                    int priority = input.nextInt();

                    while (priority < 1 || priority > 3) {
                        System.out.println("Priority must be 1, 2 or 3.");
                        System.out.print("Enter Priority: ");
                        priority = input.nextInt();
                    }

                    Task task = new Task(id, name, priority);

                    list.add(task);

                    System.out.println("Task added successfully.");

                    break;


                case 2:

                    System.out.println("\n--- TASKS ---");

                    list.display();

                    break;


                case 3:

                    System.out.print("Enter Task ID to search: ");
                    int searchId = input.nextInt();

                    Task found = list.search(searchId);

                    if (found != null) {
                        System.out.println("Task Found:");
                        found.display();
                    } else {
                        System.out.println("Task not found.");
                    }

                    break;


                case 4:

                    list.sort();

                    System.out.println("Tasks sorted by priority.");

                    list.display();

                    break;


                case 5:

                    System.out.print("Enter Task ID to delete: ");
                    int deleteId = input.nextInt();

                    Task deleted = list.delete(deleteId);

                    if (deleted != null) {

                        stack.push(deleted);

                        System.out.println("Task deleted.");

                    } else {

                        System.out.println("Task not found.");
                    }

                    break;


                case 6:

                    if (stack.isEmpty()) {

                        System.out.println("Nothing to undo.");

                    } else {

                        Task undoTask = stack.pop();

                        list.add(undoTask);

                        System.out.println("Last deleted task restored.");
                    }

                    break;


                case 7:

                    System.out.println("\n--- STACK ---");

                    stack.display();

                    break;


                case 8:

                    System.out.println("Program ended.");

                    break;


                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        input.close();
    }
}