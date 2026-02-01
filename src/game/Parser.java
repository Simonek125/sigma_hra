package game;

import Commands.Command;
import java.util.Map;

public class Parser {
    private Map<String, Command> commands;

    public Parser() {
        commands = new java.util.HashMap<>();
        registerCommand(new Commands.CommandGo());
        registerCommand(new Commands.CommandQuit());
        registerCommand(new Commands.CommandHelp());
        registerCommand(new Commands.CommandTake());
        registerCommand(new Commands.CommandDrop());
        registerCommand(new Commands.CommandTalk());
        registerCommand(new Commands.CommandExamine());
        // Add other commands here
    }

    private void registerCommand(Command cmd) {
        commands.put(cmd.getName(), cmd);
    }

    public Command parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }
        String cmdName = input.trim().split(" ")[0];
        return commands.get(cmdName);
    }

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

    public String getAllHelp() {
        StringBuilder sb = new StringBuilder();
        for (Command cmd : commands.values()) {
            sb.append(cmd.getHelp()).append("\n");
        }
        return sb.toString();
    }
}
