package by.nhorushko.factory;

import by.nhorushko.command.*;
import by.nhorushko.menu.Menu;
import by.nhorushko.model.StudentDatabase;
import by.nhorushko.model.Token;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class CommandFactory {
    private final Scanner scanner;
    private final StudentDatabase database;
    private final Menu menu;

    public Command create(Token token) {
        switch (token) {
            case LOAD -> {
                return new LoadDatabaseCommand(scanner, database, menu);
            }
            case CREATE -> {
                return new CreateDatabaseCommand(scanner, database, menu);
            }
            case EXIT -> {
                return new ExitCommand();
            }
            case ADD -> {
                return new AddStudentCommand(scanner, database);
            }
            case REMOVE -> {
                return new RemoveStudentCommand(scanner, database);
            }
            case ALL -> {
                return new ViewAllGradesCommand(scanner, database);
            }
            case ADD_GRADES -> {
                return new AddStudentGradesCommand(scanner, database);
            }
            case UPDATE_GRADE -> {
                return new UpdateGradeCommand(scanner, database);
            }
            case REMOVE_GRADE -> {
                return new RemoveGradeCommand(scanner, database);
            }
            case VIEW -> {
                return new ViewStudentGradeCommand(scanner, database);
            }
            case SAVE -> {
                return new SaveDatabaseCommand(scanner, database);
            }
            case MAIN -> {
                return new StopMenuCommand(menu);
            }
            default -> {
                return new InvalidCommand();
            }
        }
    }
}
