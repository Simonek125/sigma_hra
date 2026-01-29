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
        System.out.println("Vitejte ve hre!");
        System.out.println(player.getCurrentRoom().getLongDescription());

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.print("> ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                processCommand(input);
            } else {
                break;
            }
        }
        scanner.close();
        System.out.println("Hra ukoncena.");
    }

    public void processCommand(String input) {
        Command command = parser.parse(input);
        if (command != null) {
            String[] args = parser.parseArgs(input);
            String result = command.execute(args, this);
            if (result != null) {
                System.out.println(result);
            }
        } else {
            System.out.println("Neznamy prikaz.");
        }
    }

    public void stop() {
        isRunning = false;
    }

    public Parser getParser() {
        return parser;
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return null;
    }
}
