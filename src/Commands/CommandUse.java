package Commands;

import game.Game;

public class CommandUse implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Co mam pouzit?";
        }

        String itemName = args[0];
        game.Item item = game.getPlayer().getInventory().get(itemName);

        if (item == null) {
            return "To nemas v batohu.";
        }

        game.Room currentRoom = game.getPlayer().getCurrentRoom();
        // Logic for Bylina
        if (item.getId().equals("bylina")) {

            if (currentRoom.getName().equals("Opuštěný srub")) {
                game.NPC jezevec = currentRoom.getNPCById("jezevec");
                if (jezevec != null) {
                    currentRoom.removeNPC(jezevec);
                    game.getPlayer().getInventory().remove("bylina");
                    return "Dal jsi bylinu jezevcovi. Ten si ji přiložil na bolavý zub, spokojeně zamručel a odbelhal se pryč.";
                }
            }
            return "Tady bylinu nemůžeš smysluplně použít.";
        }

        // Logic for Orisek
        if (item.getId().equals("orisek")) {
            if (currentRoom.getName().equals("Doubravka")) {
                game.NPC veverka = currentRoom.getNPCById("veverka");
                if (veverka != null) {
                    game.getPlayer().getInventory().remove("orisek");
                    game.Item mech = new game.Item("mech", "Měkký mech", "Ideální na vystlání pelíšku.", "material");
                    game.getPlayer().getInventory().add(mech);
                    return "Veverka ti vytrhla oříšek z ruky a hodila po tobě kus mechu. 'Díky!' zavolala.";
                }
            }
            return "Tady oříšek nikdo nechce.";
        }

        // Logic for Kamen
        if (item.getId().equals("kamen")) {
            if (currentRoom.getName().equals("Jeskyně")) {
                game.getPlayer().getInventory().remove("kamen");
                game.setEntranceBlocked(true);

                return "S námahou jsi převalil kámen a ucpal jím vchod do jeskyně. Teď je tu bezpečno.";
            }
            return "Tady kámene nic neucpeš.";
        }

        // Logic for Deka
        if (item.getId().equals("deka")) {
            if (currentRoom.getName().equals("Jeskyně")) {
                game.getPlayer().getInventory().remove("deka");
                game.setHasBlanket(true);
                if (game.hasBed())
                    return "Rozprostřel jsi deku na zem. Postel je kompletní!";
                return "Rozprostřel jsi deku na zem. Ještě to chce něco měkkého (mech).";
            }
            return "Tady deku dávat nebudeš.";
        }

        // Logic for Mech
        if (item.getId().equals("mech")) {
            if (currentRoom.getName().equals("Jeskyně")) {
                game.getPlayer().getInventory().remove("mech");
                game.setHasMoss(true);
                if (game.hasBed())
                    return "Vystlal jsi místo mechem. Postel je kompletní!";
                return "Vystlal jsi místo mechem. Ještě to chce deku.";
            }
            return "Tady mech k ničemu není.";
        }

        return "Nevim jak toto pouzit.";
    }

    @Override
    public String getName() {
        return "pouzij";
    }

    @Override
    public String getHelp() {
        return "pouzij [predmet] - Pouzije predmet v inventari nebo mistnosti";
    }
}
