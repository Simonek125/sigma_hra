package Commands;

import game.Game;

public class CommandTalk implements Command {
    /**
     * Pokusí se najít osobu/zvíře (NPC) v místnosti a promluvit na ni.
     */
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "S kym si mam promluvit?";
        }

        String targetName = String.join(" ", args);

        // Zkouší nejprve přesnou či jednoduchou shodu v místnosti
        game.NPC npc = game.getPlayer().getCurrentRoom().getNPC(targetName);
        if (npc == null) {
            // Pokud ji nenajde, zkusí projít jména s částečnou shodou (ignoruje velikost
            // písmen)
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
