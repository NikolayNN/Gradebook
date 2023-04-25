package by.nhorushko.command;

import by.nhorushko.menu.MenuLayer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StopMenuCommand implements Command {
    private final MenuLayer menuLayer;
    @Override
    public void execute() {
        menuLayer.stop();
    }
}
