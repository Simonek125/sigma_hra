package Commands;

import game.Game;

public class CommandExamine implements Command {
    /**
     * Prozkoumá zadaný předmět nebo osobu.
     * Vyhledává nejprve v batohu, poté přesně v místnosti,
     * a nakonec částečnou shodou v obojím.
     */
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam prozkoumat?";
        }

        // Spojení všech argumentů do jednoho názvu
        String targetName = String.join(" ", args);
        game.Room room = game.getPlayer().getCurrentRoom();

        // 1. Zkontroluje v batohu přesným názvem
        if (game.getPlayer().getInventory().hasItem(targetName)) {
            return game.getPlayer().getInventory().get(targetName).getDescription();
        }

        // 2. Zkontroluje v místnosti přesným názvem
        if (room.getInventory().hasItem(targetName)) {
            return room.getInventory().get(targetName).getDescription();
        }

        // 3. Zkontroluje postavy (NPC) v místnosti s částečnou shodou
        for (game.NPC npc : room.getNPCs()) {
            if (npc.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return npc.getDescription();
            }
        }

        // 4. Zkontroluje podrobně všechny předměty v místnosti (částečná shoda)
        for (game.Item item : room.getInventory().getItems()) {
            if (item.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return item.getDescription();
            }
        }

        // 5. Zkontroluje podrobně všechny předměty v batohu (částečná shoda)
        for (game.Item item : game.getPlayer().getInventory().getItems()) {
            if (item.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return item.getDescription();
            }
        }

        return "Nic takoveho tu nevidim.";
    }

    /** @return Název příkazu "prozkoumej" */
    @Override
    public String getName() {
        return "prozkoumej";
    }

    @Override
    public String getHelp() {
        return "prozkoumej [vec] - Poskytne detailni popis predmetu nebo okoli";
    }
}
