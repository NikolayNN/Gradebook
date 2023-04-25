package by.nhorushko;

import by.nhorushko.command.*;
import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static Scanner scanner = new Scanner(System.in);

    private static StudentDatabase database = new StudentDatabase();

    public static void main(String[] args) {
        System.out.println("Welcome to the Grades Tracker program!");

        boolean programRunning = true;
        while (programRunning) {
            System.out.println("\nPlease choose an option from the menu below:");
            System.out.println("l - Load existing database from file");
            System.out.println("c - Create new database");
            System.out.println("e - Exit program");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "l":
                    new LoadDatabaseCommand(scanner, database).execute();
                    showMainMenu();
                    break;
                case "c":
                    new CreateDatabaseCommand(scanner, database).execute();
                    showMainMenu();
                    break;
                case "e":
                    new ExitCommand(scanner).execute();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Grades Tracker program!");
    }

    private static void showMainMenu() {
        boolean menuRunning = true;
        while (menuRunning) {
            System.out.println("\nPlease choose an option from the menu below:");
            System.out.println("add - Add a new student");
            System.out.println("remove - Remove a student");
            System.out.println("update - Update a student's grade");
            System.out.println("addgrades - add student grades");
            System.out.println("all -  View all students' grades");
            System.out.println("view - View a specific student's grades");
            System.out.println("save - Save database to file");
            System.out.println("main - Return to main menu");

            String choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "add" -> new AddStudentCommand(scanner, database).execute();
                case "remove" -> new RemoveStudentCommand(scanner, database).execute();
                case "update" -> new UpdateGradeCommand(scanner, database).execute();
                case "all" -> new ViewAllGradesCommand(scanner, database).execute();
                case "addgrades" -> new AddStudentGradesCommand(scanner, database).execute();
                case "view" -> new ViewStudentGradeCommand(scanner, database).execute();
                case "save" -> new SaveDatabaseCommand(scanner, database).execute();
                case "main" -> menuRunning = false;
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
