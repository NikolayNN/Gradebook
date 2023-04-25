package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddStudentGradesCommand extends Command {
    private final StudentDatabase database;

    public AddStudentGradesCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String name = receiveStudentName();
        List<Integer> grades = receiveMarks();
        database.addGrade(name, grades);
    }

    private List<Integer> receiveMarks() {
        String marks = receiveString("Please enter marks through comma");
        return Arrays.stream(marks.trim().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(mark -> Math.min(mark, 10))
                .collect(Collectors.toList());
    }
}
