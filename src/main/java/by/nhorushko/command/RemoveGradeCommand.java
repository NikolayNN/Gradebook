package by.nhorushko.command;

import by.nhorushko.model.StudentDatabase;

import java.util.Scanner;

public class RemoveGradeCommand extends UpdateGradeCommand {
    public RemoveGradeCommand(Scanner scanner, StudentDatabase database) {
        super(scanner, database);
    }

    @Override
    public void execute() {
        String name = receiveStudentName();
        printGradesWithIndex(name);
        int index = receiveInt("Please enter index of grade to remove:") - 1;
        database.removeGrade(name, index);
        System.out.println("Grade successfully removed");
    }
}
