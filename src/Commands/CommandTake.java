package Commands;

import game.Game;

public class CommandTake implements Command {
    /**
     * Zkusí vložit předmět do batohu hráče.
     * Obsahuje i logiku pro specifické předměty (např. deka, kterou hlídá jezevec).
     */
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam vzit?";
        }

        String itemName = args[0];

        // Specifická herní pravidla pro určitý předmět
        if (itemName.equals("deka")) {
            game.Room room = game.getPlayer().getCurrentRoom();
            // Jezevec brání hráči vzít deku
            if (room.getNPCById("jezevec") != null) {
                return "Jezevec vrčí a nenechá tě vzít deku. Musíš se ho nějak zbavit.";
            }
        }

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
