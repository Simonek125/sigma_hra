package Commands;

import game.Game;

public class CommandDrop implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "poloz";
    }

    @Override
    public String getHelp() {
        return "poloz [predmet] - Vyhodi predmet z batohu do aktualni mistnosti";
    }
}
