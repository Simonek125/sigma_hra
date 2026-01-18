package Commands;

import game.Game;

public class CommandUse implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "pouzij";
    }

    @Override
    public String getHelp() {
        return "pouzij [predmet] - Pouzije predmet v inventari nebo mistnosti";
    }
}
