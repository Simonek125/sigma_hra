package Commands;

import game.Game;

public class CommandEat implements Command {
    /**
     * Pokusí se sníst zadaný předmět.
     */
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam snist?";
        }

        String itemName = args[0];
        game.Item item = game.getPlayer().getInventory().get(itemName);

        if (item == null) {
            return "To nemas v batohu.";
        }

        // Delegování logiky jedení na samotného hráče
        return game.getPlayer().eat(item);
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
