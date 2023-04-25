package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class SaveDatabaseCommand extends AbstractCommand {
    private final StudentDatabase database;
    public SaveDatabaseCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String path = receiveString("Please enter path to file:");
        database.saveToFile(path);
        System.out.println("Successfully saved");
    }
}
