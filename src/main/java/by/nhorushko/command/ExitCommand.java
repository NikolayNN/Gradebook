package by.nhorushko.command;

import java.util.Scanner;

public class ExitCommand extends Command{
    public ExitCommand(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void execute() {
        System.out.println("Shutting down...");
        System.exit(1);
    }
}
