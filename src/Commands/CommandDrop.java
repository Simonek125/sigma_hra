package Commands;

import game.Game;

public class CommandDrop implements Command {
    /**
     * Zahodí předmět z batohu zpět do aktuální místnosti.
     */
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam polozit?";
        }

        String itemName = args[0];
        boolean success = game.getPlayer().dropItem(itemName);

        if (success) {
            return "Polozil jsi " + itemName;
        } else {
            return "To nemas v batohu.";
        }
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
