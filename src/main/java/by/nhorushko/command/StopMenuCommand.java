package by.nhorushko.command;

import by.nhorushko.menu.Menu;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StopMenuCommand implements Command {
    private final Menu menu;
    @Override
    public void execute() {
        menu.stop();
    }
}
