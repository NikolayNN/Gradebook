package by.nhorushko.command;

import java.util.Scanner;

public class ExitCommand implements Command {

    @Override
    public void execute() {
        System.out.println("Shutting down...");
        System.exit(1);
    }
}
