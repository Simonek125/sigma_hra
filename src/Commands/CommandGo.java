package Commands;

import game.Game;

public class CommandGo implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "jdi";
    }

    @Override
    public String getHelp() {
        return "jdi [smer] - Presune se do vedlejsi mistnosti (sever, jih, vychod, zapad)";
    }
}
