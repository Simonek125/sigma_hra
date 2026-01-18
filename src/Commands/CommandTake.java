package Commands;

import game.Game;

public class CommandTake implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "vezmi";
    }

    @Override
    public String getHelp() {
        return "vezmi [predmet] - Vlozi predmet do batohu";
    }
}
