package Commands;

import game.Game;

public class CommandQuit implements Command {
    /**
     * Vynutí bezpečné ukončení hry.
     */
    @Override
    public String execute(String[] args, Game game) {
        game.stop();
        return "Ukoncuji hru...";
    }

    /** @return Název příkazu "konec" */
    @Override
    public String getName() {
        return "konec";
    }

    @Override
    public String getHelp() {
        return "konec - Ukonci hru";
    }
}
