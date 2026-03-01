package Commands;

import game.Game;

public interface Command {

    /**
     * Spustí příkaz.
     * 
     * @param args Pole argumentů zadaných za příkazem (např. předmět k sebrání)
     * @param game Aktuální instance hry pro přístup k jejímu stavu
     * @return Odpověď, kterou hra vypíše do konzole po provedení
     */
    String execute(String[] args, Game game);

    /** @return Název příkazu (první slovo, které hráč zadává) */
    String getName();

    /** @return Nápověda, která popisuje fungování tohoto příkazu */
    String getHelp();
}
