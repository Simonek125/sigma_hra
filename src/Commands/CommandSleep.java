package Commands;

import game.Game;

public class CommandSleep implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (!game.getPlayer().getCurrentRoom().getName().equals("Jeskyně")) {
            return "Tady nemůžeš spát. Musíš být doma v jeskyni.";
        }

        game.checkWin();
        if (game.getWorld() != null) {
        }
        StringBuilder missing = new StringBuilder("Nemůžeš usnout, něco ti chybí:\n");
        boolean ready = true;

        if (game.getPlayer().getSaturation() < 100) {
            missing.append("- Máš hlad (sytost: ").append(game.getPlayer().getSaturation()).append("/100)\n");
            ready = false;
        }
        if (!game.hasBed()) {
            missing.append("- Nemáš ustláno (potřebuješ deku a mech)\n");
            ready = false;
        }
        if (!game.isEntranceBlocked()) {
            missing.append("- Vchod do jeskyně není ucpaný (táhne sem)\n");
            ready = false;
        }

        if (!ready)
            return missing.toString();

        return "Divné... měl bys vyhrát."; // Should not happen if checkWin logic is same
    }

    @Override
    public String getName() {
        return "spi";
    }

    @Override
    public String getHelp() {
        return "spi - Ulozi se k zimnimu spanku (pokud jsou splneny vsechny podminky)";
    }
}
