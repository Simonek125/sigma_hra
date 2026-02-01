package Commands;

import game.Game;

public class CommandTake implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam vzit?";
        }

        String itemName = args[0];
        boolean success = game.getPlayer().takeItem(itemName);

        if (success) {
            return "Vzal jsi " + itemName;
        } else {
            return "To tu neni nebo to nemuzes vzit.";
        }
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
