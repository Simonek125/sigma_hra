package Commands;

import game.Game;

public class CommandUse implements Command {
    /**
     * Aplikuje předmět z batohu v aktuální místnosti.
     * Obsahuje specifická pravidla (hardcoded logiku) jako léčení jezevce bylinou
     * nebo podání oříšku veverce atp.
     */
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

        // Logika použití byliny: Vyléčí jezevce a tím jej odstraní jako překážku
        if (item.getId().equals("bylina")) {

            if (currentRoom.getName().equals("Opuštěný srub")) {
                game.NPC jezevec = currentRoom.getNPCById("jezevec");
                if (jezevec != null) {
                    currentRoom.removeNPC(jezevec); // Odebrání jezevce z místnosti
                    game.getPlayer().getInventory().remove("bylina");
                    return "Dal jsi bylinu jezevcovi. Ten si ji přiložil na bolavý zub, spokojeně zamručel a odbelhal se pryč.";
                }
            }
            return "Tady bylinu nemůžeš smysluplně použít.";
        }

        // Logika použití oříšku: Slouží na pohoštění veverky výměnou za mech
        if (item.getId().equals("orisek")) {
            if (currentRoom.getName().equals("Doubravka")) {
                game.NPC veverka = currentRoom.getNPCById("veverka");
                if (veverka != null) {
                    game.getPlayer().getInventory().remove("orisek");
                    // Darování oříšku přidá hráči Mech do inventáře jako odměnu
                    game.Item mech = new game.Item("mech", "Měkký mech", "Ideální na vystlání pelíšku.", "material");
                    game.getPlayer().getInventory().add(mech);
                    return "Veverka ti vytrhla oříšek z ruky a hodila po tobě kus mechu. 'Díky!' zavolala.";
                }
            }
            return "Tady oříšek nikdo nechce.";
        }

        // Logika použití kamene: Slouží pro bezpečné ucpání jeskyně před spaním
        if (item.getId().equals("kamen")) {
            if (currentRoom.getName().equals("Jeskyně")) {
                game.getPlayer().getInventory().remove("kamen");
                game.setEntranceBlocked(true); // Zapíše do hry, že je úkryt zabezpečen

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
