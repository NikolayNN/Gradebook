package by.nhorushko.command;

import by.nhorushko.model.Student;
import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class AddStudentCommand extends Command {
    private final StudentDatabase database;

    public AddStudentCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String name = receiveString("Please enter the student's name:");
        database.addStudent(new Student(name));
        System.out.println("Student added successfully!");
    }
}
