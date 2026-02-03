package Commands;

import game.Game;

public class CommandTalk implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "S kym si mam promluvit?";
        }

        String targetName = String.join(" ", args);

        game.NPC npc = game.getPlayer().getCurrentRoom().getNPC(targetName);
        if (npc == null) {

            for (game.NPC n : game.getPlayer().getCurrentRoom().getNPCs()) {
                if (n.getName().toLowerCase().contains(targetName.toLowerCase())) {
                    npc = n;
                    break;
                }
            }
        }

        if (npc != null) {
            return npc.getName() + ": \"" + npc.talk() + "\"";
        }

        return "Takovou postavu tu nevidim.";
    }

    @Override
    public String getName() {
        return "mluv";
    }

    @Override
    public String getHelp() {
        return "mluv [postava] - Zahaji konverzaci s postavou v mistnosti";
    }
}
