package by.nhorushko.menu;

import by.nhorushko.model.StudentDatabase;

import java.util.List;
import java.util.Scanner;

import static by.nhorushko.model.Token.*;

public class MenuStudent extends Menu {

    public MenuStudent(Scanner scanner, StudentDatabase database) {
        super(scanner, database);
    }

    @Override
    protected void setAvailableTokens() {
        this.availableTokens = List.of(ADD, REMOVE, ALL, ADD_GRADES, UPDATE_GRADE, REMOVE_GRADE, VIEW, SAVE, MAIN, EXIT);
    }
}

