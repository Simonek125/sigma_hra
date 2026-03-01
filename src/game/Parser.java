package game;

import Commands.Command;
import java.util.Map;

public class Parser {
    private Map<String, Command> commands;

    /**
     * Inicializuje parser a zaregistruje všechny dostupné herní příkazy.
     */
    public Parser() {
        commands = new java.util.HashMap<>();
        registerCommand(new Commands.CommandGo());
        registerCommand(new Commands.CommandQuit());
        registerCommand(new Commands.CommandHelp());
        registerCommand(new Commands.CommandTake());
        registerCommand(new Commands.CommandDrop());
        registerCommand(new Commands.CommandTalk());
        registerCommand(new Commands.CommandExamine());
        registerCommand(new Commands.CommandEat());
        registerCommand(new Commands.CommandUse());
        registerCommand(new Commands.CommandSleep());
    }

    /**
     * Zaregistruje nový příkaz do mapy příkazů podle jeho názvu.
     * 
     * @param cmd Instance příkazu
     */
    private void registerCommand(Command cmd) {
        commands.put(cmd.getName(), cmd);
    }

    /**
     * Analyzuje vstup a vrátí odpovídající příkaz.
     * 
     * @param input Celý řetězec zadaný uživatelem
     * @return Nalezený příkaz nebo null, pokud příkaz neexistuje
     */
    public Command parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null; // Zadaný vstup je prázdný
        }
        // Oddělí první slovo, které reprezentuje název příkazu
        String cmdName = input.trim().split(" ")[0];
        return commands.get(cmdName);
    }

    /**
     * Získá argumenty ze zadaného vstupu (vše kromě prvního slova - příkazu).
     * 
     * @param input Celý řetězec zadaný uživatelem
     * @return Pole textových argumentů
     */
    public String[] parseArgs(String input) {
        if (input == null || input.trim().isEmpty()) {
            return new String[0];
        }
        String[] parts = input.trim().split(" ");
        if (parts.length > 1) {
            String[] args = new String[parts.length - 1];
            System.arraycopy(parts, 1, args, 0, parts.length - 1);
            return args;
        }
        return new String[0];
    }

    /**
     * Vytvoří a vrátí textovou nápovědu obsahující popis všech příkazů.
     * 
     * @return Formátovaný řetězec s návodem ke každému příkazu
     */
    public String getAllHelp() {
        StringBuilder sb = new StringBuilder();
        for (Command cmd : commands.values()) {
            sb.append(cmd.getHelp()).append("\n"); // Vloží nápovědu daného příkazu na nový řádek
        }
        return sb.toString();
    }
}
