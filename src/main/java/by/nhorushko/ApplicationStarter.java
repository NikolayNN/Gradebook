package by.nhorushko;

import by.nhorushko.menu.MenuLayerMain;
import by.nhorushko.menu.MenuLayerStudent;
import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public abstract class ApplicationStarter {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentDatabase database = new StudentDatabase();

    public static void start() {
        MenuLayerMain main = new MenuLayerMain(scanner, database);
        MenuLayerStudent student = new MenuLayerStudent(scanner, database);
        main.setRelative(student);
        student.setRelative(main);

        System.out.println("Welcome to the Grades Tracker program!");
        main.start();
    }
}
