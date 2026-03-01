package game;

import Commands.Command;
import java.util.Scanner;

public class Game {
    private boolean isRunning;
    private Player player;
    private World world;
    private Parser parser;

    /**
     * Konstruktor inicializuje hru, svět, hráče a parser příkazů.
     */
    public Game() {
        world = new World();
        world.initWorld(); // Načtení dat světa (místnosti, předměty, NPC)
        player = new Player("Barnabas", world.getRoom("jeskyne"));
        parser = new Parser();
        isRunning = true;
    }

    /**
     * Hlavní herní smyčka, která čte a zpracovává příkazy od hráče,
     * dokud není hra ukončena.
     */
    public void play() {
        System.out.println("Vitejte ve hre!");
        System.out.println(player.getCurrentRoom().getLongDescription());

        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            System.out.print("> ");
            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                processCommand(input); // Zpracování zadání
            } else {
                break;
            }
        }
        scanner.close();
        System.out.println("Hra ukoncena.");
    }

    /**
     * Zpracuje textový vstup uživatele a spustí odpovídající příkaz.
     * 
     * @param input Celý řetězec zadaný uživatelem
     */
    public void processCommand(String input) {
        Command command = parser.parse(input);
        if (command != null) {
            // Získání argumentů příkazu a provedení příkazu
            String[] args = parser.parseArgs(input);
            String result = command.execute(args, this);
            if (result != null) {
                System.out.println(result);
            }
        } else {
            System.out.println("Neznamy prikaz.");
        }
    }

    /**
     * Ukončí běh hry.
     */
    public void stop() {
        isRunning = false;
    }

    /**
     * Vrací parser pro aktuální hru.
     */
    public Parser getParser() {
        return parser;
    }

    /**
     * Vrací aktuálního hráče.
     */
    public Player getPlayer() {
        return player;
    }

    private boolean isEntranceBlocked;
    private boolean hasBed;
    private boolean hasBlanket;
    private boolean hasMoss;

    /**
     * Nastaví, zda má hráč přikrývku.
     */
    public void setHasBlanket(boolean hasBlanket) {
        this.hasBlanket = hasBlanket;
        checkBed();
    }

    /**
     * Nastaví, zda má hráč mech do postýlky.
     */
    public void setHasMoss(boolean hasMoss) {
        this.hasMoss = hasMoss;
        checkBed();
    }

    /**
     * Zkontroluje, zda má hráč obě potřebné části pro postýlku (deku a mech).
     */
    private void checkBed() {
        if (hasBlanket && hasMoss) {
            hasBed = true;
            System.out.println("Tvoje postýlka je hotová a měkoučká!");
        }
    }

    /**
     * Vrací instanci herního světa.
     */
    public World getWorld() {
        return world;
    }

    /**
     * Nastaví, zda je vchod do jeskyně ucpaný.
     */
    public void setEntranceBlocked(boolean blocked) {
        this.isEntranceBlocked = blocked;
    }

    /**
     * Vrací stav vchodu do jeskyně.
     */
    public boolean isEntranceBlocked() {
        return isEntranceBlocked;
    }

    /**
     * Nastaví stav postýlky (zda je připravena).
     */
    public void setHasBed(boolean hasBed) {
        this.hasBed = hasBed;
    }

    /**
     * Vrací stav postýlky.
     */
    public boolean hasBed() {
        return hasBed;
    }

    /**
     * Zkontroluje podmínky pro vítězství ve hře (zazimování).
     * Hráč musí být v jeskyni, vchod musí být ucpaný,
     * postel hotová a hráč musí mít plnou sytost.
     */
    public void checkWin() {
        if (player.getCurrentRoom().getName().equals("Jeskyně") &&
                isEntranceBlocked &&
                hasBed &&
                player.getSaturation() >= 100) {
            System.out.println("Gratuluji! Uctil jsi všechny podmínky pro zimní spánek.");
            System.out.println(
                    "Barnabáš se zavrta do mekouckého mechu, vchod je bezpečně ucpaný a bříško má plné.");
            System.out.println("Dobrou noc, Barnabáši!");
            stop(); // Vítězství ukončí hru
        }
    }
}
