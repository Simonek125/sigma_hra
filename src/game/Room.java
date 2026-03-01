package game;

import java.util.Map;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private Inventory items;
    private List<NPC> npcs;

    /**
     * Vytvoří novou instanci místnosti.
     * 
     * @param name        Název místnosti
     * @param description Popis místnosti
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.exits = new java.util.HashMap<>();
        this.items = new Inventory(10); // Výchozí kapacita inventáře místnosti
        this.npcs = new java.util.ArrayList<>();
    }

    /**
     * Přidá východ z místnosti do určeného směru.
     * 
     * @param direction Směr východu (např. jméno navazující místnosti)
     * @param room      Cílová místnost
     */
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    /**
     * Získá místnost v zadaném směru.
     * 
     * @param direction Směr východu
     * @return Sousední místnost nebo null, pokud neexistuje
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * Přidá předmět do místnosti.
     * 
     * @param item Předmět k přidání
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Odebere předmět z místnosti podle jeho jména.
     * 
     * @param itemName Jméno předmětu
     * @return Odebíraný předmět nebo null, pokud se v místnosti nenachází
     */
    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    /**
     * Přidá postavu (NPC) do místnosti.
     * 
     * @param npc Postava
     */
    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    /**
     * Najde a vrátí postavu (NPC) podle jejího jména.
     * 
     * @param name Hledané jméno částečně odpovídající jménu NPC
     * @return Nalezené NPC nebo null
     */
    public NPC getNPC(String name) {
        for (NPC npc : npcs) {
            // Kontrola jména s ignorováním velikosti písmen
            if (npc.getName().toLowerCase().contains(name.toLowerCase()))
                return npc;
        }
        return null;
    }

    /**
     * Odebere postavu z místnosti.
     * 
     * @param npc Postava k odebrání
     */
    public void removeNPC(NPC npc) {
        npcs.remove(npc);
    }

    /**
     * Získá postavu v místnosti podle jejího jedinečného ID.
     * 
     * @param id Identifikátor NPC
     * @return NPC nebo null
     */
    public NPC getNPCById(String id) {
        for (NPC npc : npcs) {
            if (npc.getId().equals(id))
                return npc;
        }
        return null;
    }

    /**
     * @return Dlouhý popis místnosti včetně věcí a osob, které se v ní nachází.
     */
    public String getLongDescription() {
        String npcString = "";
        for (NPC npc : npcs) {
            npcString += npc.getName() + " ";
        }
        if (npcs.isEmpty())
            npcString = "nikdo";

        return "Jsi v: " + name + "\n" +
                description + "\n" +
                "Veci: " + items.listItems() + "\n" +
                "Postavy: " + npcString.trim() + "\n" +
                "Vychody: " + exits.keySet();
    }

    /** @return Název místnosti */
    public String getName() {
        return name;
    }

    /** @return Seznam všech postav v místnosti */
    public List<NPC> getNPCs() {
        return npcs;
    }

    /** @return Inventář místnosti obsahující všechny dostupné předměty */
    public Inventory getInventory() {
        return items;
    }
}
