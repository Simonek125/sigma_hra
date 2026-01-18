package Commands;

import game.Game;

public class CommandTalk implements Command {
    @Override
    public String execute(String[] args, Game game) {
        return null;
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
