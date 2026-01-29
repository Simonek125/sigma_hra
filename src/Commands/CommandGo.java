package Commands;

import game.Game;

import game.Room;

public class CommandGo implements Command {
    @Override
    public String execute(String[] args, Game game) {
        if (args.length == 0) {
            return "Kam mam jit?";
        }

        String direction = args[0];
        Room currentRoom = game.getPlayer().getCurrentRoom();

        if (currentRoom.getExit(direction) != null) {
            Room nextRoom = currentRoom.getExit(direction);
            game.getPlayer().move(nextRoom);
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
