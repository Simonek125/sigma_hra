package Commands;

import game.Game;

public class CommandHelp implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
    }

    @Override
    public String getName() {
        return "pomoc";
    }

    @Override
    public String getHelp() {
        return "pomoc - Vypise tento seznam prikazu";
    }
}
