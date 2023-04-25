package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class LoadDatabaseCommand extends Command {
    private final StudentDatabase database;
    public LoadDatabaseCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String filePath = receiveString("Please enter the file path of the database:");
        try {
            database.loadFromFile(filePath);
            System.out.println("Database loaded successfully!");
        } catch (Exception e) {
            System.out.println("Error loading database: " + e.getMessage());
        }
    }
}
