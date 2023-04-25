package by.nhorushko.menu;

import by.nhorushko.factory.CommandFactory;
import by.nhorushko.model.Token;
import by.nhorushko.command.Command;
import by.nhorushko.model.StudentDatabase;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {

    protected final Scanner scanner;
    protected final StudentDatabase database;
    protected final CommandFactory commandFactory;

    protected List<Token> availableTokens = new ArrayList<>();

    @Setter
    private Menu relative;

    private boolean isRunning = false;

    public Menu(Scanner scanner, StudentDatabase database) {
        this.scanner = scanner;
        this.database = database;
        this.commandFactory = new CommandFactory(this.scanner, this.database, this);
    }

    protected abstract void setAvailableTokens();

    public void start() {
        isRunning = true;
        setAvailableTokens();
        run();
    }

    public void stop() {
        isRunning = false;
    }

    private void run() {
        while (isRunning) {
            printMenuOptions();
            String input = receiveToken();
            try {
                Token token = Token.valueOf(input.toUpperCase());
                checkTokenAvailable(token);
                commandFactory.create(token).execute();
            } catch (Exception e) {
                System.out.printf("Error while run command: '%s' message: '%s'%n", input, e.getMessage());
            }
        }
        relative.start();
    }

    private void checkTokenAvailable(Token token) {
        if (!availableTokens.contains(token)) {
            throw new RuntimeException(String.format("Token: '%s', not available for this menu", token));
        }
    }

    private String receiveToken() {
        return scanner.nextLine().toLowerCase();
    }

    private void printMenuOptions() {
        StringBuilder result = new StringBuilder();
        for (Token c : availableTokens) {
            result.append(c.name().toLowerCase()).append(" - ").append(c.getDescription()).append("\n");
        }
        System.out.printf("\nPlease choose an option from the menu below:\n%s", result);
    }
}
