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

    private boolean isEntranceBlocked;
    private boolean hasBed;
    private boolean hasBlanket;
    private boolean hasMoss;

    public void setHasBlanket(boolean hasBlanket) {
        this.hasBlanket = hasBlanket;
        checkBed();
    }

    public void setHasMoss(boolean hasMoss) {
        this.hasMoss = hasMoss;
        checkBed();
    }

    private void checkBed() {
        if (hasBlanket && hasMoss) {
            hasBed = true;
            System.out.println("Tvoje postýlka je hotová a měkoučká!");
        }
    }

    public World getWorld() {
        return world;
    }

    public void setEntranceBlocked(boolean blocked) {
        this.isEntranceBlocked = blocked;
    }

    public boolean isEntranceBlocked() {
        return isEntranceBlocked;
    }

    public void setHasBed(boolean hasBed) {
        this.hasBed = hasBed;
    }

    public boolean hasBed() {
        return hasBed;
    }

    public void checkWin() {
        if (player.getCurrentRoom().getName().equals("Jeskyně") &&
                isEntranceBlocked &&
                hasBed &&
                player.getSaturation() >= 100) {
            System.out.println("Gratuluji! Uctil jsi všechny podmínky pro zimní spánek.");
            System.out.println(
                    "Barnabáš se zavrta do mekouckého mechu, vchod je bezpečně ucpaný a bříško má plné.");
            System.out.println("Dobrou noc, Barnabáši!");
            stop();
        }
    }
}
