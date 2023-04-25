package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.List;
import java.util.Scanner;

public class UpdateGradeCommand extends Command {

    private final StudentDatabase database;

    public UpdateGradeCommand(Scanner scanner, StudentDatabase database) {
        super(scanner);
        this.database = database;
    }

    @Override
    public void execute() {
        String name = receiveStudentName();
        printGradesWithIndex(name);
        int index = receiveInt("Please enter index of grade to update:") - 1;
        int grade = receiveInt("Please enter new grade:");
        database.getGrades(name).set(index, grade);
        System.out.println("Grade successfully updated:");
    }

    private void printGradesWithIndex(String name) {
        List<Integer> grades = database.getGrades(name);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < grades.size(); i++) {
            result.append(i + 1).append(": ").append(grades.get(i)).append(", ");
        }
        System.out.println(result);
    }
}
