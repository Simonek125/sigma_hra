package game;

import Commands.Command;
import java.util.Scanner;

public class Game {
    private boolean isRunning;
    private Player player;
    private World world;
    private Parser parser;

    public Game() {
        world = new World();
        world.initWorld();
        player = new Player("Barnabas", world.getRoom("jeskyne"));
        parser = new Parser();
        isRunning = true;
    }

    public void play() {

    }

    public void processCommand(String input) {

    }

    public void stop() {

    }

    public Player getPlayer() {
        return null;
    }

    public World getWorld() {
        return null;
    }
}
