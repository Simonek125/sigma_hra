package Commands;

import game.Game;

public class CommandExamine implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam prozkoumat?";
        }

        String targetName = String.join(" ", args);
        game.Room room = game.getPlayer().getCurrentRoom();

        // Check Inventory (Backpack)
        if (game.getPlayer().getInventory().hasItem(targetName)) {
            return game.getPlayer().getInventory().get(targetName).getDescription();
        }

        // Check Room Items
        if (room.getInventory().hasItem(targetName)) {
            return room.getInventory().get(targetName).getDescription();
        }

        // Check Room NPCs
        for (game.NPC npc : room.getNPCs()) {
            if (npc.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return npc.getDescription();
            }
        }

        // Also check if user examines "room" or "mistnost" ?
        // Or if item in room inventory with fuzzy match?
        for (game.Item item : room.getInventory().getItems()) {
            if (item.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return item.getDescription();
            }
        }

        // Check backpack fuzzy
        for (game.Item item : game.getPlayer().getInventory().getItems()) {
            if (item.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return item.getDescription();
            }
        }

        return "Nic takoveho tu nevidim.";
    }

    @Override
    public String getName() {
        return "prozkoumej";
    }

    @Override
    public String getHelp() {
        return "prozkoumej [vec] - Poskytne detailni popis predmetu nebo okoli";
    }
}
