package game;

import java.util.Map;

public class World {
    private Map<String, Room> rooms;

    /**
     * Vytvoří herní svět a připraví mapu místností.
     */
    public World() {
        rooms = new java.util.HashMap<>();
    }

    /**
     * Inicializuje herní svět - načte místnosti, předměty a postavy (NPC)
     * z konfiguračního souboru "gamedata.json" a propojí jednotlivé místnosti.
     */
    public void initWorld() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        // 1. Vytvoření všech místností podle dat z JSON souboru
        for (LocationData loc : data.getLocations()) {
            Room room = new Room(loc.getName(), loc.getDescription());

            // Načtení předmětů a jejich přidání do místnosti
            if (loc.getItems() != null) {
                for (ItemData itemData : loc.getItems()) {
                    Item item = new Item(itemData.getId(), itemData.getName(), itemData.getDescription(),
                            itemData.getType());
                    room.addItem(item);
                }
            }

            // Načtení postav a jejich přidání do místnosti
            if (loc.getCharacters() != null) {
                for (NPCData npcData : loc.getCharacters()) {
                    NPC npc = new NPC(npcData.getId(), npcData.getName(), npcData.getDescription(), npcData.getType(),
                            npcData.getDialog());
                    room.addNPC(npc);
                }
            }

            rooms.put(loc.getId(), room);
        }

        // 2. Propojení místností (vytvoření východů)
        for (LocationData loc : data.getLocations()) {
            Room currentRoom = rooms.get(loc.getId());
            if (loc.getNeighbors() != null) {
                for (String neighborId : loc.getNeighbors()) {
                    Room neighborRoom = rooms.get(neighborId);
                    if (neighborRoom != null) {
                        // Přidá sousední místnost jako východ (směr odpovídá jejímu ID)
                        currentRoom.addExit(neighborId, neighborRoom);
                    }
                }
            }
        }
    }

    /**
     * Vrátí místnost na základě zadaného jména.
     * 
     * @param name Název (klíč) místnosti
     * @return Hledaná místnost
     */
    public Room getRoom(String name) {
        return rooms.get(name);
    }
}
