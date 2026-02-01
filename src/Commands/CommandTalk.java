package Commands;

import game.Game;

public class CommandTalk implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "S kym si mam promluvit?";
        }

        // But since parser splits by space, args is array. We probably should join them
        // back if name has spaces?
        // Actually, our getNPC in Room matches exact name.
        // Let's assume for now user types one word or we reconstruct.
        // Given current parser implementation, args is array of words.
        // Let's try to match partial name or full name.

        // For simplicity, let's take the first arg as name, or iterate to find match.
        // A better approach: search for NPC in room whose name contains the input
        // string?
        // Or reconstruct string.

        // Let's reconstruct the name from args to support multi-word names like
        // "Veverka Ciperka"
        String targetName = String.join(" ", args);

        game.NPC npc = game.getPlayer().getCurrentRoom().getNPC(targetName);
        if (npc == null) {
            // Try partial match or just first word if full match fails?
            // The user might type "mluv veverka" instead of "mluv Veverka Ciperka".
            // Let's try partial matching in Room.getNPC?
            // For now, let's keep it exact or rely on finding ANY npc with that substring?
            // Let's modify Room.getNPC to be smarter or do it here.

            // Let's try to find an NPC whose name contains the target string (case
            // insensitive)
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
