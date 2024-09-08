package lms.module4.assignment1;
import java.util.Scanner;

public class ToDoListApp {
	private static final int MAX_TASKS = 100; // Maximum number of tasks in the to-do list
	private static String[] tasks = new String[MAX_TASKS]; // Array to store tasks
	private static int taskCount = 0; // Counter to track the number of tasks

	// Method to add a task
	public static void addTask(String task) {
		if (taskCount < MAX_TASKS) {
			tasks[taskCount] = task; // Add the task to the array
			taskCount++;
			System.out.println("Task added successfully.");
		} else {
			System.out.println("Task list is full. Unable to add more tasks.");
		}
	}

	// Method to remove a task by its index
	public static void removeTask(int index) {
		if (index < 0 || index >= taskCount) {
			System.out.println("Invalid task index.");
		} else {
			// Shift tasks left after removing the task
			for (int i = index; i < taskCount - 1; i++) {
				tasks[i] = tasks[i + 1];
			}
			tasks[taskCount - 1] = null; // Clear the last task
			taskCount--;
			System.out.println("Task removed successfully.");
		}
	}

	// Method to display the to-do list
	public static void viewTasks() {
		if (taskCount == 0) {
			System.out.println("To-do list is empty.");
		} else {
			System.out.println("Your to-do list:");
			for (int i = 0; i < taskCount; i++) {
				System.out.println((i + 1) + ". " + tasks[i]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			// Display menu
			System.out.println("\nTo-Do List Menu:");
			System.out.println("1. Add Task");
			System.out.println("2. Remove Task");
			System.out.println("3. View Tasks");
			System.out.println("4. Exit");
			System.out.print("Choose an option (1-4): ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline

			switch (choice) {
			case 1:
				// Add a task
				System.out.print("Enter the task: ");
				String task = scanner.nextLine();
				addTask(task);
				break;
			case 2:
				// Remove a task
				System.out.print("Enter the task number to remove: ");
				int taskNumber = scanner.nextInt();
				removeTask(taskNumber - 1); // Adjust index (1-based to 0-based)
				break;
			case 3:
				// View tasks
				viewTasks();
				break;
			case 4:
				// Exit
				running = false;
				System.out.println("Exiting the To-Do List app.");
				break;
			default:
				System.out.println("Invalid choice. Please choose again.");
			}
		}

		scanner.close();
	}
}
