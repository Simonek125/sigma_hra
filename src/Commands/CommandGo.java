package Commands;

import game.Game;

import game.Room;

public class CommandGo implements Command {
    /**
     * Pokusí se přesunout hráče do zadané místnosti na základě směru.
     */
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Kam mam jit?";
        }

        String direction = args[0]; // Jméno požadované místnosti nebo směru
        Room currentRoom = game.getPlayer().getCurrentRoom();

        // Pokud v aktuální místnosti existuje tento východ
        if (currentRoom.getExit(direction) != null) {
            Room nextRoom = currentRoom.getExit(direction);
            game.getPlayer().move(nextRoom);
            // Vrátí dlouhý popis nové místnosti
            return nextRoom.getLongDescription();
        }

        return "Tam se neda jit.";
    }

    @Override
    public String getName() {
        return "jdi";
    }

    @Override
    public String getHelp() {
        return "jdi [mistnost] - Presune se do sousedni mistnosti (napr. 'rozcesti', 'les')";
    }
}
