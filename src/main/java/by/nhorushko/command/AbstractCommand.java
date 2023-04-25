package by.nhorushko.command;

import java.util.Scanner;

public abstract class AbstractCommand implements Command {
    private final Scanner scanner;

    public AbstractCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    public abstract void execute();

    protected int receiveInt(String prompt) {
        System.out.println("\n" + prompt);
        return Integer.parseInt(scanner.nextLine());
    }


    protected String receiveString(String prompt) {
        System.out.println("\n" + prompt);
        return scanner.nextLine();
    }

    protected String receiveStudentName() {
        return receiveString("Please enter the student's name:");
    }
}
