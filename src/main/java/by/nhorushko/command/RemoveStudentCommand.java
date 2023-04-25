package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class RemoveStudentCommand extends AbstractCommand {
    private final StudentDatabase database;

    public RemoveStudentCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String name = receiveString("Please enter the student's name:");
        database.removeStudent(name);
        System.out.println("Student removed successfully!");
    }
}
