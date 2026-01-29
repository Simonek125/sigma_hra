package Commands;

import game.Game;

public class CommandQuit implements Command {
    @Override
    public String execute(String[] args, Game game) {
        game.stop();
        return "Ukoncuji hru...";
    }

    @Override
    public String getName() {
        return "konec";
    }

    @Override
    public String getHelp() {
        return "konec - Ukonci hru";
    }
}
