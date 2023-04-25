package by.nhorushko;

import by.nhorushko.menu.MenuMain;
import by.nhorushko.menu.MenuStudent;
import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public abstract class ApplicationStarter {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDatabase database = new StudentDatabase();

    public static void start() {
        MenuMain main = new MenuMain(scanner, database);
        MenuStudent student = new MenuStudent(scanner, database);
        main.setRelative(student);
        student.setRelative(main);

        System.out.println("Welcome to the Grades Tracker program!");
        main.start();
    }
}
