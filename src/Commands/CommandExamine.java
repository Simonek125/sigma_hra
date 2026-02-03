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

        if (game.getPlayer().getInventory().hasItem(targetName)) {
            return game.getPlayer().getInventory().get(targetName).getDescription();
        }

        if (room.getInventory().hasItem(targetName)) {
            return room.getInventory().get(targetName).getDescription();
        }

        for (game.NPC npc : room.getNPCs()) {
            if (npc.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return npc.getDescription();
            }
        }

        for (game.Item item : room.getInventory().getItems()) {
            if (item.getName().toLowerCase().contains(targetName.toLowerCase())) {
                return item.getDescription();
            }
        }

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
