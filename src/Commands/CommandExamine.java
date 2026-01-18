package Commands;

import game.Game;

public class CommandExamine implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
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
