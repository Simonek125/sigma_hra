package Commands;

import game.Game;

public class CommandEat implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "snez";
    }

    @Override
    public String getHelp() {
        return "snez [jidlo] - Sni jidlo a zvysi sytost";
    }
}
