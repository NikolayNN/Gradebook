package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewStudentGradeCommand extends Command {
    protected final StudentDatabase database;

    public ViewStudentGradeCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String name = receiveStudentName();
        database.getGrades(name);
        printGrades(name);
    }

    protected void printGrades(String name) {
        String result = database.getGrades(name).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(name + " : " + result);
    }
}
