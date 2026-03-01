package Commands;

import game.Game;

public class CommandHelp implements Command {
    /**
     * Získá textovou nápovědu se všemi dostupnými příkazy od parseru.
     */
    @Override
    public String execute(String[] args, Game game) {
        return game.getParser().getAllHelp();
    }

    /** @return Název příkazu "pomoc" */
    @Override
    public String getName() {
        return "pomoc";
    }

    @Override
    public String getHelp() {
        return "pomoc - Vypise tento seznam prikazu";
    }
}
