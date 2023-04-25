package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class CreateDatabaseCommand extends Command {
    private final StudentDatabase database;

    public CreateDatabaseCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        database.clear();
        System.out.println("Database created successfully!");
    }
}
