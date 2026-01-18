package Commands;

import game.Game;

public interface Command {

    String execute(String[] args, Game game);


    String getName();


    String getHelp();
}
