package Commands;

import game.Game;

public class CommandSleep implements Command {
    /**
     * Zkontroluje, zda hráč může jít spát a vyhrát hru.
     */
    @Override
    public String execute(String[] args, Game game) {
        // Hráč musí být v úvodní jeskyni
        if (!game.getPlayer().getCurrentRoom().getName().equals("Jeskyně")) {
            return "Tady nemůžeš spát. Musíš být doma v jeskyni.";
        }

        // Zkusí spustit ověření vítězství (checkWin), které ukončí hru úspěchem,
        // pokud jsou všechny podmínky splněny
        game.checkWin();
        if (game.getWorld() != null) {
        }

        // Pokud hra neskončila vítězstvím, zjišťujeme, co přesně chybí
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
