package by.nhorushko.menu;

import by.nhorushko.model.StudentDatabase;

import java.util.List;
import java.util.Scanner;

import static by.nhorushko.model.Token.*;

public class MenuLayerMain extends MenuLayer {

    public MenuLayerMain(Scanner scanner, StudentDatabase database) {
        super(scanner, database);
    }

    @Override
    protected void setAvailableTokens() {
        this.availableTokens = List.of(LOAD, CREATE, EXIT);
    }
}
