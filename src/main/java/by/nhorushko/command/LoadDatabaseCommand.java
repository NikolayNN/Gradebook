package by.nhorushko.command;

import by.nhorushko.menu.MenuLayer;
import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class LoadDatabaseCommand extends AbstractCommand {
    private final StudentDatabase database;
    private final MenuLayer current;

    public LoadDatabaseCommand(Scanner scanner, StudentDatabase database, MenuLayer current) {
        super(scanner);
        this.database = database;
        this.current = current;
    }

    @Override
    public void execute() {
        String filePath = receiveString("Please enter the file path of the database:");
        try {
            database.loadFromFile(filePath);
            System.out.println("Database loaded successfully!");
            current.stop();
        } catch (Exception e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
    }
}
