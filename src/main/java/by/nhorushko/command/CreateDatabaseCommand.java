package by.nhorushko.command;

import by.nhorushko.menu.Menu;
import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class CreateDatabaseCommand extends AbstractCommand {
    private final StudentDatabase database;
    private final Menu current;

    public CreateDatabaseCommand(Scanner scanner, StudentDatabase database, Menu current) {
        super(scanner);
        this.database = database;
        this.current = current;
    }

    @Override
    public void execute() {
        database.clear();
        System.out.println("Database created successfully!");
        current.stop();
    }
}
