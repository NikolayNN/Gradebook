package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class ViewAllGradesCommand extends ViewStudentGradeCommand {
    public ViewAllGradesCommand(Scanner scanner, StudentDatabase database) {
        super(scanner, database);
    }

    @Override
    public void execute() {
        database.getAllGrades().keySet().forEach(this::printGrades);
    }
}
